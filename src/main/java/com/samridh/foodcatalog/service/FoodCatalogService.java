package com.samridh.foodcatalog.service;


import com.samridh.foodcatalog.dto.FoodCatalogPage;
import com.samridh.foodcatalog.dto.FoodItemDTO;
import com.samridh.foodcatalog.dto.Restaurant;
import com.samridh.foodcatalog.entity.FoodItem;
import com.samridh.foodcatalog.exception.FoodItemNotFoundException;
import com.samridh.foodcatalog.mapper.FoodItemMapper;
import com.samridh.foodcatalog.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private RestTemplate restTemplate;

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItem = FoodItemMapper.INSTANCE.mapFoodItemDtoToFoodItem(foodItemDTO);
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(foodItemRepository.save(foodItem));
    }

    public FoodCatalogPage fetchFoodCataloPageDetails(Integer restaurantId) {
        List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsFrmRestaurantMS(restaurantId);
        return createFoodCataloguePage(foodItemList, restaurant);
    }

    private FoodCatalogPage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCatalogPage foodCataloguePage = new FoodCatalogPage();
        foodCataloguePage.setFoodItemList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    private Restaurant fetchRestaurantDetailsFrmRestaurantMS(Integer restaurantId) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchRestaurantById/" + restaurantId, Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId);
    }
}

package com.samridh.foodcatalog.controller;

import com.samridh.foodcatalog.dto.FoodCatalogPage;
import com.samridh.foodcatalog.dto.FoodItemDTO;
import com.samridh.foodcatalog.service.FoodCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalog")
public class FoodCatalogController {


    @Autowired
    private FoodCatalogService foodCatalogService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO> addFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
        FoodItemDTO savedFoodItem = foodCatalogService.addFoodItem(foodItemDTO);
        return new ResponseEntity<>(savedFoodItem, HttpStatus.CREATED);

    }

    @GetMapping("/fetchRestaurantAndFoodItemsById/{id}")
    public ResponseEntity<FoodCatalogPage> fetchRestaurantsDetailsWithFoodMenu(@PathVariable Integer id) {
        FoodCatalogPage foodCatalogPage = foodCatalogService.fetchFoodCataloPageDetails(id);
        return new ResponseEntity<>(foodCatalogPage, HttpStatus.OK);
    }


}

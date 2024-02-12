package com.samridh.foodcatalog.repository;

import com.samridh.foodcatalog.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {
    List<FoodItem> findByRestaurantId(Integer restaurantId);
}

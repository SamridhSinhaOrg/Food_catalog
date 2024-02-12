package com.samridh.foodcatalog.dto;


import com.samridh.foodcatalog.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCatalogPage {

    private List<FoodItem> foodItemList;
    private Restaurant restaurant;
}

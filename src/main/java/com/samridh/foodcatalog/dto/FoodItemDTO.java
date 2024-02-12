package com.samridh.foodcatalog.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDTO {

    private Integer id;

    private String itemName;

    private String itemDescription;


    private Boolean isVeg;

    private Number price;

    private Integer restaurantId;


    private Integer quantity;
}

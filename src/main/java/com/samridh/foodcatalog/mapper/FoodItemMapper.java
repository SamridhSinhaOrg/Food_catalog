package com.samridh.foodcatalog.mapper;


import com.samridh.foodcatalog.dto.FoodItemDTO;
import com.samridh.foodcatalog.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItemDTO mapFoodItemToFoodItemDto(FoodItem foodItem);

    FoodItem mapFoodItemDtoToFoodItem(FoodItemDTO foodItemDTO);


}

package com.example.newCar.demo.parseDto.images;

import lombok.Data;

import java.util.List;
@Data
public class CarImagesDto {
    CarImageDto mainImageDto;
    List<CarImageDto> imageDtos;
}

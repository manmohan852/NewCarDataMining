package com.example.newCar.demo.parseDto;

import com.example.newCar.demo.parseDto.feature.FeatureDto;
import com.example.newCar.demo.parseDto.images.CarImagesDto;
import com.example.newCar.demo.parseDto.specification.SpecificationDto;
import lombok.Data;

import java.util.List;

@Data
public class CarDto {

    String price;
    String fuelType;
    String mileage;
    String seatingCapacity;
    String safetyRating;
    String warranty;
    String batteryWarranty;
    String engineSize;
    String transmission;
    String size;
    String fuelTank;
    String groundClearance;
}

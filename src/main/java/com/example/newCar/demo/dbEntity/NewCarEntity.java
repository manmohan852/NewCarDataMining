package com.example.newCar.demo.dbEntity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("new_car_entity")
@Data
public class NewCarEntity {

    @Id
    private String price;
    private String fuelType;
    private String mileage;
    private String seatingCapacity;
    private String safetyRating;
    private String warranty;
    private String engineSize;
    private String transmission;
    private String size;
    private String fuelTank;
    private String BatteryWarranty;
    private String groundClearance;

}

package com.example.newCar.demo.service;

import com.example.newCar.demo.dbEntity.NewCarEntity;
import com.example.newCar.demo.parseDto.CarDto;
import com.example.newCar.demo.repository.NewCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataIngestionService {

    @Autowired
    NewCarRepository newCarRepository;
    public void transformAndIngestInDB(CarDto carDto) {
        NewCarEntity newCarEntity = new NewCarEntity();
        try{
            newCarEntity.setPrice(carDto.getPrice());
            newCarEntity.setFuelType(carDto.getFuelType());
            newCarEntity.setMileage(carDto.getMileage());
            newCarEntity.setSeatingCapacity(carDto.getSeatingCapacity());
            newCarEntity.setSafetyRating(carDto.getSafetyRating());
            newCarEntity.setWarranty(carDto.getWarranty());
            newCarEntity.setEngineSize(carDto.getEngineSize());
            newCarEntity.setTransmission(carDto.getTransmission());
            newCarEntity.setFuelTank(carDto.getFuelTank());
            newCarEntity.setGroundClearance(carDto.getGroundClearance());
            newCarEntity.setSize(carDto.getSize());
            newCarEntity.setBatteryWarranty(carDto.getBatteryWarranty());



        }
        catch(Exception exception){
            System.out.println("Exception trace : "+ exception.getLocalizedMessage());
        }
        if(isValidatedEntity(newCarEntity))
        {
            newCarRepository.save(newCarEntity);
        }
    }
    private boolean isValidatedEntity(NewCarEntity newCarEntity) {
        return true;
    }
}

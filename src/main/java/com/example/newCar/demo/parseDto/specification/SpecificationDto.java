package com.example.newCar.demo.parseDto.specification;

import lombok.Data;

@Data
public class SpecificationDto {
    EngineDto engineDto;
    TransmissionDto transmissionDto;
    DimensionDto dimensionDto;
    WeightDto weightDto;
    CapacityDto capacityDto;
    SuspensionDto suspensionDto;
    BrakeDto brakeDto;
    SteeringDto steeringDto;
    TyresDto tyresDto;
}

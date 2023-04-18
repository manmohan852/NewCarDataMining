package com.example.newCar.demo.repository;

import com.example.newCar.demo.dbEntity.NewCarEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewCarRepository extends MongoRepository<NewCarEntity, String> {


}

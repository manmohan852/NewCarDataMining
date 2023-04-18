package com.example.newCar.demo.repository;

import com.example.newCar.demo.dbEntity.NewCarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Repository
public class NewCarRepositoryDao {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<NewCarEntity> findNewCarBasedOnCriteria(Query query){
        List<NewCarEntity> result = mongoTemplate.find(query, NewCarEntity.class);
        return result;
    }
}
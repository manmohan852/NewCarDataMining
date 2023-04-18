package com.example.newCar.demo.service;

import com.example.newCar.demo.dbEntity.NewCarEntity;
import com.example.newCar.demo.repository.NewCarRepository;
import com.example.newCar.demo.repository.NewCarRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Map;
@Service
public class NewCarContentService {

    @Autowired
    NewCarRepository newCarRepository;
    @Autowired
    NewCarRepositoryDao newCarRepositoryDao;

    public List<NewCarEntity> getCarAllDetails() {
        return newCarRepository.findAll();
    }

    public List<NewCarEntity> getCarDetails(Map<String, String> reqParam) {
        Query query = new Query();
        for (String key : reqParam.keySet())
        {
            Criteria criteria = Criteria.where(key).is(reqParam.get(key));
            query.addCriteria(criteria);
        }
        return newCarRepositoryDao.findNewCarBasedOnCriteria(query);
    }
}

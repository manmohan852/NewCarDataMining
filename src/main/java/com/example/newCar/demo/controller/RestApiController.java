package com.example.newCar.demo.controller;


import com.example.newCar.demo.apiDto.ApiResponse;
import com.example.newCar.demo.constants.AppConstants;
import com.example.newCar.demo.dbEntity.NewCarEntity;
import com.example.newCar.demo.service.DataParseService;
import com.example.newCar.demo.service.NewCarContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RestApiController {


    @Autowired
    NewCarContentService newCarContentService;

    @Autowired
    DataParseService dataParseService;

    @RequestMapping(path = AppConstants.TEST_URI, method = RequestMethod.GET,
            headers = "Accept=application/json", produces = "application/json")
    public ApiResponse doTest() {
        return new ApiResponse(HttpStatus.OK.value(), AppConstants.SUCCESS_MESSAGE, HttpStatus.OK);
    }


    @RequestMapping(path = AppConstants.FIND_ALL_NEW_CAR_URI, method = RequestMethod.GET,
            headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody List<NewCarEntity> getCarAllDetails() {
        return newCarContentService.getCarAllDetails();
    }

    @RequestMapping(path = AppConstants.FIND_NEW_CAR_URI, method = RequestMethod.GET,
            headers = "Accept=application/json", produces = "application/json")
    public @ResponseBody List<NewCarEntity> getCarDetails(@RequestParam Map<String, String> reqParam ) {
        return newCarContentService.getCarDetails(reqParam);
    }
}

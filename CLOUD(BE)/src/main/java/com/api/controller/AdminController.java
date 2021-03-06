package com.api.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.sql.Date;

import com.api.domain.APIDataItem;
import com.api.domain.Rating;
import com.api.domain.DailyMeal;

import com.api.mapper.RatingMapper;
import com.api.service.MenuService;
import com.api.service.RatingService;
import com.api.util.ParsingData;
import com.google.gson.JsonObject;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class AdminController {

    @Autowired
    ParsingData parsingData;

    @Autowired
    MenuService menuService;

    @Autowired
    RatingService ratingService;

    // OK
    @RequestMapping(value = "/save/menu/{group}/{start}/{end}", method = RequestMethod.GET)
    public ResponseEntity saveAllMenu(@PathVariable("start") String startIdx, @PathVariable("end")String endIdx, @PathVariable("group")String groupNum){
        return new ResponseEntity<List<HashMap<String, Object>>>(parsingData.saveData(startIdx, endIdx, groupNum), HttpStatus.OK);
    }

    // OK
    @RequestMapping(value = "/save/dailymenu/{group}/{start}/{end}", method = RequestMethod.GET)
    public ResponseEntity saveAllDailyMenu(@PathVariable("start") String startIdx, @PathVariable("end")String endIdx, @PathVariable("group")String groupNum){
        return new ResponseEntity<List<HashMap<String,Object>>>(parsingData.setDailyMenu(Long.valueOf(groupNum), startIdx, endIdx, groupNum), HttpStatus.OK);
    }
}

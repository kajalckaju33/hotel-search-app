package com.holidaycheck.hotelsearch.controller;

import com.holidaycheck.hotelsearch.service.HotelSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;


@RestController
public class HotelSearchController {

    @Autowired
    HotelSearchService hotelSearchService;

    @GetMapping("/hotels")
    @ResponseBody
    public ArrayList<Map<String,String>> findHotels(@RequestParam(required = true, value = "stars") int stars) {
        return hotelSearchService.findHotels(stars);
    }

}
package com.holidaycheck.hotelsearch.service;

import com.holidaycheck.hotelsearch.controller.HotelSearchController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Map;

@SpringBootTest
class HotelsearchServiceTest {

	@Autowired
    HotelSearchService hotelSearchService;

	@Test
	void findHotelsTest()  {
		ArrayList<Map<String,String>> result =  hotelSearchService.findHotels(3);
		Assert.notEmpty(result);
	}
}

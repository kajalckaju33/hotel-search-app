package com.holidaycheck.hotelsearch.controller;

import com.holidaycheck.hotelsearch.service.HotelSearchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class HotelsearchControllerTest {

	@Autowired
	HotelSearchController hotelSearch;

	@Mock
	HotelSearchService hotelSearchService;

	@Test
	void findHotelsTest()  {
		Map<String,String> outputMap = new HashMap<>();
		outputMap.put("name","\"Hotel Mountain Budget\"");
		outputMap.put("destination","tyrol");
		outputMap.put("stars","2");
		ArrayList<Map<String,String>> outputList = new ArrayList<>();
		outputList.add(outputMap);

		ArrayList<Map<String,String>> result =  hotelSearch.findHotels(2);
		Mockito.when(hotelSearchService.findHotels(2)).thenReturn(outputList);
		Assertions.assertEquals(result,outputList);
	}
}

package com.holidaycheck.hotelsearch.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class HotelSearchService {

    public static final String FILE_NAME = "src/main/resources/Json/HotelsInformation.json";
    public static final String NAME = "name";
    public static final String STARS = "stars";
    public static final String DESTINATION = "destination";

    public ArrayList<Map<String,String>> findHotels(int stars) {
        JsonParser jsonParser = new JsonParser();
        ArrayList<Map<String,String>> resultData = new ArrayList<>();
        try (FileReader reader = new FileReader(FILE_NAME))
        {
            Object obj = jsonParser.parse(reader);
            JsonObject jsonObject = (JsonObject) ((JsonArray) obj).get(0);
            for (Map.Entry<String, JsonElement> param : jsonObject.entrySet()) {
                Map<String, String> tempData = new HashMap<>();
                String location = param.getKey();
                JsonElement locationValue = param.getValue();
                for(JsonElement item : locationValue.getAsJsonArray()){
                    if(stars == Integer.parseInt(item.getAsJsonObject().get(STARS).toString())){
                        tempData.put(NAME,item.getAsJsonObject().get(NAME).toString());
                        tempData.put(STARS,item.getAsJsonObject().get(STARS).toString());
                        tempData.put(DESTINATION, location);
                        resultData.add(tempData);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultData;
    }

}
package com.example.project;

import com.google.gson.Gson;

import java.util.Map;

public class JsonToMapParser {
    public static Map parse(String json) {
        Gson gson = new Gson();
        Map map = gson.fromJson(json, Map.class);
        return map;
    }
}

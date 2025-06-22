package com.thinkdestructive.Restload.Utility;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestJson {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert object to JSON", e);
        }
    }
}

package com.softsurroundings.soft.surroundings.debug;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Debug {


    public static void log(Object objectToJson) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(objectToJson));
        }catch (Exception e) {
            System.out.println("Failed to write object to string");
        }

    }

}

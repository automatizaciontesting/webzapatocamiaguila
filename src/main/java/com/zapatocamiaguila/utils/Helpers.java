package com.zapatocamiaguila.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Helpers {

    Logger logger  = Logger.getLogger(Helpers.class.getName());
    public static Map<String, String> data = new HashMap<>();

    public void delayElement(int seconds) {
        try {
            Thread.sleep(seconds * (long) 1000);
        } catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
    }
}

package com.goit.restaurant.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoCommons {

    private static final Logger LOGGER = LoggerFactory.getLogger(DaoCommons.class);

    public static final String URL = "jdbc:postgresql://localhost:5432/restaurant";
    public static final String USER = "user";
    public static final String PASSWORD = "12345";

    public static void loadDriver() {
        try {
            LOGGER.info("Loading JDBC driver: org.postgresql.Driver");
            Class.forName("org.postgresql.Driver");
            LOGGER.info("Driver successfully loaded");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Cannot find driver: org.postgresql.Driver");
            throw new RuntimeException(e);
        }
    }

}

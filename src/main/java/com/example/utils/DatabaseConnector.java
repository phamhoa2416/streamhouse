package com.example.utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final Dotenv dotenv = Dotenv.load();

    private static final String POSTGRES_URL = dotenv.get("POSTGRES_URL");
    private static final String POSTGRES_USER = dotenv.get("POSTGRES_USER");
    private static final String POSTGRES_PASSWORD = dotenv.get("POSTGRES_PASSWORD");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(POSTGRES_URL, POSTGRES_USER, POSTGRES_PASSWORD);
    }
}

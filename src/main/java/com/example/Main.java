package com.example;

import com.example.generator.CustomerDataGenerator;
import com.example.model.Customer;
import com.example.seeder.CustomerDataSeeder;
import com.example.utils.DatabaseConnector;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            System.out.println("Connected to PostgreSQL successfully!");

            while (true) {
                Customer customer = CustomerDataGenerator.generateCustomer();
                System.out.println("Generated Customer: " + customer);
                CustomerDataSeeder.insertCustomer(conn, customer);

                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.err.println("Error running data seeder: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

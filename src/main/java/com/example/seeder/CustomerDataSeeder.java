package com.example.seeder;

import com.example.model.Customer;

import java.sql.*;

public class CustomerDataSeeder {
    private static final String INSERT_SQL =
            "INSERT INTO customers (first_name, last_name, email, phone, date_of_birth, " +
                    "address, city, country, postal_code, registration_date, customer_since, status) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static void insertCustomer(Connection connection, Customer customer) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(INSERT_SQL)) {
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhone());
            stmt.setDate(5, java.sql.Date.valueOf(customer.getDateOfBirth()));
            stmt.setString(6, customer.getAddress());
            stmt.setString(7, customer.getCity());
            stmt.setString(8, customer.getCountry());
            stmt.setString(9, customer.getPostalCode());
            stmt.setDate(10, java.sql.Date.valueOf(customer.getRegistrationDate()));
            stmt.setTimestamp(11, Timestamp.valueOf(customer.getCustomerSince()));
            stmt.setString(12, customer.getStatus());

            stmt.executeUpdate();
        }
    }
}
package com.example.seeder;

import com.example.model.Customer;

import java.sql.*;

public class CustomerDataSeeder {
    private static final String INSERT_SQL =
            "INSERT INTO customers (customer_id, email, first_name, last_name, phone, date_of_birth, " +
                    "gender, address, city, country, postal_code, is_active, created_at, updated_at) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static void insertCustomer(Connection connection, Customer customer) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(INSERT_SQL)) {
            stmt.setString(1, customer.getCustomerId());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getFirstName());
            stmt.setString(4, customer.getLastName());
            stmt.setString(5, customer.getPhone());
            stmt.setDate(6, java.sql.Date.valueOf(customer.getDateOfBirth()));
            stmt.setString(7, customer.getGender());
            stmt.setString(8, customer.getAddress());
            stmt.setString(9, customer.getCity());
            stmt.setString(10, customer.getCountry());
            stmt.setString(11, customer.getPostalCode());
            stmt.setBoolean(12, customer.isActive());
            stmt.setTimestamp(13, Timestamp.valueOf(customer.getCreatedAt()));
            stmt.setTimestamp(14, Timestamp.valueOf(customer.getUpdatedAt()));

            stmt.executeUpdate();
        }
    }
}
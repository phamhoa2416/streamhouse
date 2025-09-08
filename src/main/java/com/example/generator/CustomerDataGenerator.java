package com.example.generator;

import com.example.model.Customer;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerDataGenerator {
    private static final Faker faker = new Faker();
    private static final AtomicInteger counter = new AtomicInteger(1);
    private static final Set<String> existIds = new HashSet<>();

    public static Customer generateCustomer() {
        String firstname = generateFirstName();
        String lastname = generateLastName();
        String email = generateEmail(firstname, lastname);
        String phone = generatePhoneNumber();
        LocalDate dateOfBirth = generateDateOfBirth();

        return Customer.builder().customerId(generateCustomerId()).email(email).firstName(firstname).lastName(lastname).phone(phone).dateOfBirth(dateOfBirth).gender(generateGender()).address(generateStreetAddress()).city(generateCity()).country(generateCountry()).postalCode(generatePostalCode()).isActive(generateActiveStatus()).createdAt(generateCreatedAt()).updatedAt(LocalDateTime.now()).build();
    }

    private static String generateCustomerId() {
        String customerId;
        do {
            customerId = String.format("CUS%04d", counter.getAndIncrement());
        } while (existIds.contains(customerId));
        existIds.add(customerId);
        return customerId;
    }

    // Name generation methods
    private static String generateFirstName() {
        return faker.name().firstName();
    }

    private static String generateLastName() {
        return faker.name().lastName();
    }

    // Email generation method
    private static String generateEmail(String firstName, String lastName) {
        String domain = "@ecommerce.example.com";
        return (firstName.charAt(0) + lastName + faker.number().digits(3) + domain).toLowerCase();
    }

    // Phone number generation method
    private static String generatePhoneNumber() {
        String rawPhone = faker.phoneNumber().cellPhone();
        return rawPhone.replaceAll("[^0-9]", "");
    }

    // Date generation methods
    private static LocalDate generateDateOfBirth() {
        Date date = faker.date().birthday(18, 80);
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    // Gender generation method
    private static String generateGender() {
        String[] genders = {"male", "female", "other"};
        return genders[faker.random().nextInt(genders.length)];
    }

    // Address generation methods
    private static String generateStreetAddress() {
        return faker.address().streetAddress();
    }

    private static String generateCity() {
        return faker.address().city();
    }

    private static String generateCountry() {
        return faker.address().country();
    }

    private static String generatePostalCode() {
        return faker.address().zipCode();
    }

    // Active status generation method
    private static boolean generateActiveStatus() {
        // 85% of customers are active
        return faker.random().nextDouble() < 0.85;
    }

    // Created at generation method
    private static LocalDateTime generateCreatedAt() {
        // Customers created within the last 3 years
        Date date = faker.date().past(365 * 3, java.util.concurrent.TimeUnit.DAYS);
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}


package com.example.generator;

import com.example.model.Customer;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CustomerDataGenerator {
    private static final Faker faker = new Faker();

    public static Customer generateCustomer() {
        String firstname = generateFirstName();
        String lastname = generateLastName();
        String email = generateEmail(firstname, lastname);
        String phone = generatePhoneNumber();
        LocalDate dateOfBirth = generateDateOfBirth();
        LocalDate registrationDate = generateRegistrationDate(dateOfBirth);

        return Customer.builder()
                .firstName(firstname)
                .lastName(lastname)
                .email(email)
                .phone(phone)
                .dateOfBirth(dateOfBirth)
                .address(generateStreetAddress())
                .city(generateCity())
                .country(generateCountry())
                .postalCode(generatePostalCode())
                .registrationDate(registrationDate)
                .customerSince(generateCustomerSince(registrationDate))
                .status(generateStatus())
                .build();
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
        String domain = "@banking.example.com";
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

    private static LocalDate generateRegistrationDate(LocalDate birthDate) {
        LocalDate minDate = birthDate.plusYears(18);
        Date date = faker.date().past(365 * 20, TimeUnit.DAYS,
                Date.from(minDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private static LocalDateTime generateCustomerSince(LocalDate registrationDate) {
        int hour = faker.number().numberBetween(8, 20);
        int minute = faker.number().numberBetween(0, 59);
        return registrationDate.atTime(hour, minute);
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

    // Status generation method
    private static String generateStatus() {
        double random = faker.random().nextDouble();
        if (random < 0.85) return "ACTIVE";
        else if (random < 0.90) return "INACTIVE";
        else if (random < 0.95) return "SUSPENDED";
        else return "CLOSED";
    }
}


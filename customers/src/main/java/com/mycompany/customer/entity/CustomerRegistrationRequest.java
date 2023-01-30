package com.mycompany.customer.entity;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}

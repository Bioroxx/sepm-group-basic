package com.example.learn.dto.response.performance;

public record AddressDto(
        String street,
        String city,
        String country,
        String zipcode
) {
}

package com.example.learn.dto.response.booking;

public record AddressDto(
        String street,
        String city,
        String country,
        String zipcode
) {
}
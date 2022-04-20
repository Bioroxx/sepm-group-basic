package com.example.learn.dto.response.location;

public record AddressDto(
        String street,
        String city,
        String country,
        String zipcode
) {
}

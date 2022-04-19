package com.example.learn.dto.get.location;

public record AddressDto(
        String street,
        String city,
        String country,
        String zipcode
) {
}

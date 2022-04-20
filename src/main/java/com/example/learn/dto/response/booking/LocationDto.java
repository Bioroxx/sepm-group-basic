package com.example.learn.dto.response.booking;

public record LocationDto(
        Long id,
        String name,
        AddressDto address) {
}

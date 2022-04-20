package com.example.learn.dto.response.performance;

public record LocationDto(
        Long id,
        String name,
        AddressDto address,
        RoomDto room
) { }

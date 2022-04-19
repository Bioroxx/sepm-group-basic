package com.example.learn.dto.get.performance;

import java.util.List;

public record LocationDto(
        Long id,
        String name,
        AddressDto address,
        RoomDto room
) { }

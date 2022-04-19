package com.example.learn.dto.get.location;

import java.util.List;

public record LocationDto(
        Long id,
        String name,
        AddressDto address,
        List<RoomDto> rooms
) { }

package com.example.learn.dto.response.location;

import java.util.List;

public record LocationDto(
        Long id,
        String name,
        AddressDto address,
        List<RoomDto> rooms
) { }

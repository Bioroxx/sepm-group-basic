package com.example.learn.dto.response.location;

import java.util.List;

public record RoomDto(
        Long id,
        String name,
        List<SectorDto> sectors)
{
}

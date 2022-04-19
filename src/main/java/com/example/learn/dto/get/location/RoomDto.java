package com.example.learn.dto.get.location;

import java.util.List;

public record RoomDto(
        Long id,
        String name,
        List<SectorDto> sectors)
{
}

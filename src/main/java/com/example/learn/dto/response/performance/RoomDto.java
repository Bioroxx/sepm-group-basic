package com.example.learn.dto.response.performance;

import java.util.List;

public record RoomDto(
        Long id,
        String name,
        List<SectorWithPriceDto> sectors)
{
}

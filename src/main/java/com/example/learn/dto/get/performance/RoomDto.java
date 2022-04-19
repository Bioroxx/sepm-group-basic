package com.example.learn.dto.get.performance;

import com.example.learn.dto.get.location.SectorDto;

import java.util.List;

public record RoomDto(
        Long id,
        String name,
        List<SectorWithPriceDto> sectors)
{
}

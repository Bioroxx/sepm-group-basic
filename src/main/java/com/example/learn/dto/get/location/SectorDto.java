package com.example.learn.dto.get.location;

import java.util.List;

public record SectorDto(
        Long id,
        String name,
        List<PlaceDto> places
) {
}

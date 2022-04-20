package com.example.learn.dto.response.location;

import java.util.List;

public record SectorDto(
        Long id,
        String name,
        List<PlaceDto> places
) {
}

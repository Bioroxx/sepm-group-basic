package com.example.learn.dto.response.performance;

public record SectorWithPriceDto(
        Long id,
        String name,
        Integer cents
) {
}

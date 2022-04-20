package com.example.learn.dto.response.booking;

public record PerformanceDto(
        Long id,
        String datetime,
        LocationDto location
) {
}

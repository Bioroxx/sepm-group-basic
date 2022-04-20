package com.example.learn.dto.response.performance;


public record PerformanceDto(
        Long id,
        String datetime,
        EventDto event,
        LocationDto location)
{ }

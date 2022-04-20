package com.example.learn.dto.response.event;

import com.example.learn.dto.response.performance.PerformanceDto;

import java.util.List;

public record EventDto(
        Long id,
        String name,
        String type,
        Double duration,
        String description,
        List<PerformanceDto> performances)
{ }

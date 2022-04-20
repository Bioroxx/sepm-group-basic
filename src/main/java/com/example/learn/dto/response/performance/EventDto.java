package com.example.learn.dto.response.performance;

public record EventDto(
        Long id,
        String name,
        String type,
        Double duration,
        String description)
{ }

package com.example.learn.dto.request.event;

public record EventDto(
        String name,
        String type,
        Double duration,
        String description)
{ }

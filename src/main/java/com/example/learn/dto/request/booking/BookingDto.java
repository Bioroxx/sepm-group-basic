package com.example.learn.dto.request.booking;

import java.util.List;

public record BookingDto(
        Long userId,
        Long performanceId,
        List<Long> placeIds)
{ }

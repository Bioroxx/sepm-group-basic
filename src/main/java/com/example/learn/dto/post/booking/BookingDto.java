package com.example.learn.dto.post.booking;

import java.util.List;

public record BookingDto(
        Long userId,
        Long performanceId,
        List<Long> placeIds)
{ }

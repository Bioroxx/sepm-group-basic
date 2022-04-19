package com.example.learn.dto.get.location;

import com.example.learn.entity.SeatType;

public record PlaceDto(
        Long id,
        Integer number,
        SeatType seatType)
{ }

package com.example.learn.dto.response.booking;

import com.example.learn.entity.SeatType;

public record PlaceDto(
        Long id,
        Integer number,
        SeatType seatType)
{ }

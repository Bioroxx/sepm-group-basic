package com.example.learn.dto.response.booking;

import com.example.learn.entity.BookingType;

import java.util.List;

public record BookingDto(
        Long id,
        BookingType bookingType,
        PerformanceDto performance,
        List<TicketDto> tickets)
{ }

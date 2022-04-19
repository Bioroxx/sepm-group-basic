package com.example.learn.dto.get.booking;

import com.example.learn.entity.BookingType;

import java.util.List;

public record BookingDto(
        Long id,
        BookingType bookingType,
        List<TicketDto> tickets)
{ }

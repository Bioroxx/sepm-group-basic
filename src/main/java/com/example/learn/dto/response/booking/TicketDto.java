package com.example.learn.dto.response.booking;

public record TicketDto(
        Long id,
        Integer cents,
        SectorDto sector,
        PlaceDto place)
{ }

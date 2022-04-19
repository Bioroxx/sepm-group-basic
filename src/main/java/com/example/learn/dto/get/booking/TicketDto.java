package com.example.learn.dto.get.booking;

public record TicketDto(
        Long id,
        SectorDto sector,
        PlaceDto place)
{ }

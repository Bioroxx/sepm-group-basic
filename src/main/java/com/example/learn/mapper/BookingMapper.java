package com.example.learn.mapper;

import com.example.learn.dto.get.booking.BookingDto;
import com.example.learn.dto.get.booking.PlaceDto;
import com.example.learn.dto.get.booking.SectorDto;
import com.example.learn.dto.get.booking.TicketDto;
import com.example.learn.entity.Booking;
import com.example.learn.entity.Ticket;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper
{
    public BookingDto entityToDto(Booking booking)
    {
        return new BookingDto(
                booking.getId(),
                booking.getBookingType(),
                booking.getTickets().stream().map(this::ticketEntityToTicketDto).toList()
        );
    }

    public TicketDto ticketEntityToTicketDto(Ticket ticket)
    {
        if(ticket.getSeatPlace() != null)
        {
            return new TicketDto(
                    ticket.getId(),
                    new SectorDto(
                            ticket.getSeatPlace().getSector().getId(),
                            ticket.getSeatPlace().getSector().getName()),
                    new PlaceDto(ticket.getSeatPlace().getId(), ticket.getSeatPlace().getNumber(), ticket.getSeatPlace().getSeatType()));
        }
        else
        {
            return new TicketDto(
                    ticket.getId(),
                    new SectorDto(
                            ticket.getStandingPlace().getSector().getId(),
                            ticket.getStandingPlace().getSector().getName()),
                    new PlaceDto(ticket.getStandingPlace().getId(), ticket.getStandingPlace().getNumber(), ticket.getStandingPlace().getSeatType()));
        }
    }
}

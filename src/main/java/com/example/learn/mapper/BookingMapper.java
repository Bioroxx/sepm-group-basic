package com.example.learn.mapper;

import com.example.learn.dto.response.booking.*;
import com.example.learn.entity.Booking;
import com.example.learn.entity.Price;
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
                new PerformanceDto(
                        booking.getPerformance().getId(),
                        booking.getPerformance().getDatetime(),
                        new LocationDto(
                                booking.getPerformance().getRoom().getLocation().getId(),
                                booking.getPerformance().getRoom().getLocation().getName(),
                                new AddressDto(
                                        booking.getPerformance().getRoom().getLocation().getAddress().getStreet(),
                                        booking.getPerformance().getRoom().getLocation().getAddress().getCity(),
                                        booking.getPerformance().getRoom().getLocation().getAddress().getCountry(),
                                        booking.getPerformance().getRoom().getLocation().getAddress().getZipcode()))),
                booking.getTickets().stream().map(this::ticketEntityToTicketDto).toList()
        );
    }

    private TicketDto ticketEntityToTicketDto(Ticket ticket)
    {
        if(ticket.getSeatPlace() != null)
        {
            return new TicketDto(
                    ticket.getId(),
                    ticket.getPerformance().getPrices().stream()
                            .filter(prices -> prices.getSector().getId().equals(ticket.getSeatPlace().getSector().getId()))
                            .map(Price::getCents)
                            .findFirst().orElseThrow(),
                    new SectorDto(
                            ticket.getSeatPlace().getSector().getId(),
                            ticket.getSeatPlace().getSector().getName()),
                    new PlaceDto(ticket.getSeatPlace().getId(), ticket.getSeatPlace().getNumber(), ticket.getSeatPlace().getSeatType()));
        }
        else
        {
            return new TicketDto(
                    ticket.getId(),
                    ticket.getPerformance().getPrices().stream()
                            .filter(prices -> prices.getSector().getId().equals(ticket.getStandingPlace().getSector().getId()))
                            .map(Price::getCents).findFirst().orElseThrow(),
                    new SectorDto(
                            ticket.getStandingPlace().getSector().getId(),
                            ticket.getStandingPlace().getSector().getName()),
                    new PlaceDto(ticket.getStandingPlace().getId(), ticket.getStandingPlace().getNumber(), ticket.getStandingPlace().getSeatType()));
        }
    }
}

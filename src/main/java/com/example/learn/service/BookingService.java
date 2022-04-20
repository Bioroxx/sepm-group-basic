package com.example.learn.service;


import com.example.learn.dto.request.booking.BookingDto;
import com.example.learn.entity.*;
import com.example.learn.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BookingService
{
    private final UserService userService;
    private final PerformanceService performanceService;
    private final TicketService ticketService;
    private final BookingRepository bookingRepository;

    public Booking bookPlaces(BookingDto bookingDto)
    {
        Performance performance = performanceService.findById(bookingDto.performanceId());

        Booking booking = new Booking();
        booking.setUser(userService.findById(bookingDto.userId()));
        booking.setBookingType(BookingType.PURCHASED);
        booking.setPerformance(performance);
        bookingRepository.save(booking);

        booking.setTickets(ticketService.bookPlacesForTicketOrder(booking, bookingDto.performanceId(), bookingDto.placeIds()));

        return booking;
    }
}

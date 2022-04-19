package com.example.learn.service;

import com.example.learn.entity.*;
import com.example.learn.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketService
{
    private final TicketRepository ticketRepository;
    private final PerformanceService performanceService;

    public List<Ticket> bookPlacesForTicketOrder(TicketOrder ticketOrder, Long performanceId, List<Long> placeIds)
    {
        // Get performance
        Performance performance = performanceService.findById(performanceId);

        List<Place> performancePlaces = new LinkedList<>();

        // Get places for this performance
        performance.getRoom().getSectors().forEach(sector -> {
            performancePlaces.addAll(sector.getPlaces());
        });

        // Validate that places are bookable for this performance
        if(placeIds.stream().anyMatch(placeId -> performancePlaces.stream().noneMatch(performancePlace -> performancePlace.getId().equals(placeId))))
            throw new IllegalArgumentException("Seat does not belong to performance");

        // Split places into standing and seating
        List<Place> sittingPlaces = new LinkedList<>();
        List<Place> standingPlaces = new LinkedList<>();

        for(Long placeId : placeIds)
        {
            Place place = performancePlaces.stream().filter(performancePlace -> performancePlace.getId().equals(placeId)).findFirst().orElseThrow();

            if(place.getSeatType().equals(SeatType.SITTING))
                sittingPlaces.add(place);
            else
                standingPlaces.add(place);
        }


        // Create tickets
        LinkedList<Ticket> tickets = new LinkedList<>();

        sittingPlaces.stream().forEach(place -> {
            Ticket ticket = new Ticket();
            ticket.setTicketOrder(ticketOrder);
            ticket.setPerformance(performance);
            ticket.setSeatPlace(place);
            tickets.add(ticket);
        });

        standingPlaces.stream().forEach(place -> {
            Ticket ticket = new Ticket();
            ticket.setTicketOrder(ticketOrder);
            ticket.setPerformance(performance);
            ticket.setStandingPlace(place);
            tickets.add(ticket);
        });

        // Save tickets
        return ticketRepository.saveAll(tickets);
    }
}

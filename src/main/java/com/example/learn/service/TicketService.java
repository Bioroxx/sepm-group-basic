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

    public List<Ticket> bookTicketsForTicketOrder(TicketOrder ticketOrder, Performance performance, List<Place> places)
    {
        // TODO: Validate that places are bookable for this performance

        LinkedList<Ticket> tickets = new LinkedList<>();

        places.stream().forEach(place -> {
            Ticket ticket = new Ticket();
            ticket.setTicketOrder(ticketOrder);
            ticket.setPerformance(performance);
            ticket.setPlace(place);
            tickets.add(ticket);
        });

        return ticketRepository.saveAll(tickets);
    }
}

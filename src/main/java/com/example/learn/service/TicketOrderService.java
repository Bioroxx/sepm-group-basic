package com.example.learn.service;


import com.example.learn.entity.*;
import com.example.learn.repository.TicketOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TicketOrderService
{
    private final TicketService ticketService;
    private final TicketOrderRepository ticketOrderRepository;

    public TicketOrder purchaseTicketOrder(User user, Long performanceId, List<Long> placeIds)
    {
        TicketOrder ticketOrder = new TicketOrder();
        ticketOrder.setUser(user);
        ticketOrder.setOrderType(OrderType.PURCHASED);

        ticketOrderRepository.save(ticketOrder);

        ticketOrder.setTickets(ticketService.bookPlacesForTicketOrder(ticketOrder, performanceId, placeIds));

        return ticketOrder;
    }
}

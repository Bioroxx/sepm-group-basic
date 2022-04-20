package com.example.learn.service;

import com.example.learn.dto.request.performance.PerformanceDto;
import com.example.learn.entity.*;
import com.example.learn.repository.PerformanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PerformanceService
{
    private final PerformanceRepository performanceRepository;
    private final RoomService roomService;
    private final EventService eventService;

    public Performance save(PerformanceDto performanceDto)
    {
        // Get event
        Event event = eventService.findById(performanceDto.eventId());


        // Get room of performanceDto
        Room room = roomService.findById(performanceDto.roomId());

        // Check if every sector has a price
        if(room.getSectors().stream().anyMatch(sector -> performanceDto.prices().stream().noneMatch(price -> price.sectorId().equals(sector.getId()))))
            throw new IllegalArgumentException("One of the sectors in this room has no price");

        Performance performance = new Performance();
        performance.setEvent(event);
        performance.setDatetime(performanceDto.datetime());
        performance.setRoom(room);

        for(Sector sector : room.getSectors())
        {
            Price price = new Price();
            price.setPerformance(performance);
            price.setSector(sector);
            price.setCents(performanceDto.prices().stream().filter(priceDto -> priceDto.sectorId().equals(sector.getId())).findFirst().orElseThrow().cents());
            performance.getPrices().add(price);
        }

        return performanceRepository.save(performance);
    }

    public Performance findById(Long id)
    {
        return performanceRepository.findById(id).orElseThrow();
    }
}

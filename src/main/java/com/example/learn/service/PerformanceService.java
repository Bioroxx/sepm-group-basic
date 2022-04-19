package com.example.learn.service;

import com.example.learn.dto.post.performance.PerformanceDto;
import com.example.learn.entity.Performance;
import com.example.learn.entity.Price;
import com.example.learn.entity.Room;
import com.example.learn.entity.Sector;
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

    public Performance save(PerformanceDto performanceDto)
    {
        // Get room of performanceDto
        Room room = roomService.findById(performanceDto.roomId());

        // Check if every sector has a price
        if(room.getSectors().stream().anyMatch(sector -> performanceDto.prices().stream().noneMatch(price -> price.sectorId().equals(sector.getId()))))
            throw new IllegalArgumentException("One of the sectors in this room has no price");

        Performance performance = new Performance();
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

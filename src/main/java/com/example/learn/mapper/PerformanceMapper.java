package com.example.learn.mapper;

import com.example.learn.dto.get.performance.*;
import com.example.learn.entity.Location;
import com.example.learn.entity.Performance;
import com.example.learn.entity.Sector;
import org.springframework.stereotype.Component;

@Component
public class PerformanceMapper
{
    public PerformanceDto entityToDto(Performance performance)
    {
        return new PerformanceDto(
                performance.getId(),
                performance.getDatetime(),
                entityToLocationDto(performance));
    }

    private LocationDto entityToLocationDto(Performance performance)
    {
        Location location = performance.getRoom().getLocation();

        return new LocationDto(
                location.getId(),
                location.getName(),
                new AddressDto(
                        location.getAddress().getStreet(),
                        location.getAddress().getCity(),
                        location.getAddress().getCountry(),
                        location.getAddress().getZipcode()),
                entityToRoomDto(performance));
    }

    private RoomDto entityToRoomDto(Performance performance)
    {
        return new RoomDto(
                performance.getRoom().getId(),
                performance.getRoom().getName(),
                performance.getRoom().getSectors().stream().map(sector -> entityToSectorWithPriceDto(sector, performance)).toList());
    }

    private SectorWithPriceDto entityToSectorWithPriceDto(Sector sector, Performance performance)
    {
        return new SectorWithPriceDto(
                sector.getId(),
                sector.getName(),
                performance.getPrices().stream().filter(prices -> prices.getSector().getId().equals(sector.getId())).map(price -> price.getCents()).findFirst().orElseThrow());
    }
}

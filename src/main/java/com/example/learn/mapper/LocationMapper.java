package com.example.learn.mapper;

import com.example.learn.dto.get.location.*;
import com.example.learn.entity.Location;
import com.example.learn.entity.Room;
import com.example.learn.entity.Sector;
import org.springframework.stereotype.Component;

@Component
public class LocationMapper
{
    public LocationDto entityToDto(Location location)
    {
        return new LocationDto(
                location.getId(),
                location.getName(),
                new AddressDto(
                        location.getAddress().getStreet(),
                        location.getAddress().getCity(),
                        location.getAddress().getCountry(),
                        location.getAddress().getZipcode()),
                location.getRooms().stream().map(this::roomEntityToRoomDto).toList()
        );
    }

    private RoomDto roomEntityToRoomDto(Room room)
    {
        return new RoomDto(
                room.getId(),
                room.getName(),
                room.getSectors().stream().map(this::sectorEntityToSectorDto).toList());
    }

    private SectorDto sectorEntityToSectorDto(Sector sector)
    {
        return new SectorDto(
                sector.getId(),
                sector.getName(),
                sector.getPlaces().stream().map(place -> new PlaceDto(place.getId(), place.getNumber(), place.getSeatType())).toList());
    }
}

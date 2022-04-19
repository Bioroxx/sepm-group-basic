package com.example.learn.service;

import com.example.learn.entity.Location;
import com.example.learn.entity.Place;
import com.example.learn.entity.Room;
import com.example.learn.entity.Sector;
import com.example.learn.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class LocationService
{
    private final LocationRepository locationRepository;

    public Location save(Location location)
    {
        // Create bidirectional references
        for(Room room : location.getRooms())
        {
            room.setLocation(location);
            for(Sector sector: room.getSectors())
            {
                sector.setRoom(room);
                for(Place place : sector.getPlaces())
                {
                    place.setSector(sector);
                }
            }
        }

        return locationRepository.save(location);
    }

    public Location findById(Long id)
    {
        return locationRepository.findById(id).orElseThrow();
    }
}

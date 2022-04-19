package com.example.learn.service;

import com.example.learn.entity.Location;
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
        return locationRepository.save(location);
    }

    public Location findById(Long id)
    {
        return locationRepository.findById(id).orElseThrow();
    }
}

package com.example.learn.api;

import com.example.learn.dto.response.location.LocationDto;
import com.example.learn.entity.Location;
import com.example.learn.mapper.LocationMapper;
import com.example.learn.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/location")
@RequiredArgsConstructor
@Slf4j
public class LocationController
{
    private final LocationService service;
    private final LocationMapper mapper;

    @PostMapping
    public ResponseEntity<LocationDto> save(@RequestBody Location location)
    {
        log.info("POST /api/v1/location " + location.toString());

        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.entityToDto(service.save(location)));
    }
}

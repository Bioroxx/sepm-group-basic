package com.example.learn.api;

import com.example.learn.dto.request.booking.BookingDto;
import com.example.learn.mapper.BookingMapper;
import com.example.learn.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/booking")
@RequiredArgsConstructor
@Slf4j
public class BookingController
{
    private final BookingService service;
    private final BookingMapper mapper;

    @PostMapping
    public ResponseEntity<com.example.learn.dto.response.booking.BookingDto> book(@RequestBody BookingDto bookingDto)
    {
        log.info("POST /api/v1/booking " + bookingDto.toString());

        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.entityToDto(service.bookPlaces(bookingDto)));
    }
}

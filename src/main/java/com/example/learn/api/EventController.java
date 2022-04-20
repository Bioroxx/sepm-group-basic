package com.example.learn.api;

import com.example.learn.dto.request.event.EventDto;
import com.example.learn.mapper.EventMapper;
import com.example.learn.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/event")
@RequiredArgsConstructor
@Slf4j
public class EventController
{
    private final EventService eventService;
    private final EventMapper eventMapper;

    @PostMapping
    public ResponseEntity<com.example.learn.dto.response.event.EventDto> save(@RequestBody EventDto eventDto)
    {
        log.info("POST /api/v1/event " + eventDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(eventMapper.entityToDto(eventService.save(eventDto)));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<com.example.learn.dto.response.event.EventDto> save(@PathVariable Long id)
    {
        log.info("GET /api/v1/event/ " + id);

        return ResponseEntity.status(HttpStatus.CREATED).body(eventMapper.entityToDto(eventService.findById(id)));
    }
}

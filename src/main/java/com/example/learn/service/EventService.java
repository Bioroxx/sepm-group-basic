package com.example.learn.service;

import com.example.learn.dto.request.event.EventDto;
import com.example.learn.entity.Event;
import com.example.learn.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EventService
{
    private final EventRepository eventRepository;

    public Event save(EventDto eventDto)
    {
        Event event = new Event();
        event.setName(eventDto.name());
        event.setType(eventDto.type());
        event.setDuration(eventDto.duration());
        event.setDescription(eventDto.description());

        return eventRepository.save(event);
    }

    public Event findById(Long id)
    {
        return eventRepository.findById(id).orElseThrow();
    }
}

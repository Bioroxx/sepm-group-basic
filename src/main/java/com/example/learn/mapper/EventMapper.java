package com.example.learn.mapper;

import com.example.learn.dto.response.event.EventDto;
import com.example.learn.entity.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventMapper
{
    private final PerformanceMapper performanceMapper;

    public EventDto entityToDto(Event event)
    {
        return new EventDto(
                event.getId(),
                event.getName(),
                event.getType(),
                event.getDuration(),
                event.getDescription(),
                event.getPerformances().stream().map(performance -> performanceMapper.entityToDto(performance)).toList());
    }
}

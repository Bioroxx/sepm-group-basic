package com.example.learn.api;

import com.example.learn.dto.post.performance.PerformanceDto;
import com.example.learn.mapper.PerformanceMapper;
import com.example.learn.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/performance")
@RequiredArgsConstructor
@Slf4j
public class PerformanceController
{
    private final PerformanceService service;
    private final PerformanceMapper mapper;

    @PostMapping
    public ResponseEntity<com.example.learn.dto.get.performance.PerformanceDto> save(@RequestBody PerformanceDto performanceDto)
    {
        log.info("POST /api/v1/performance " + performanceDto.toString());

        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.entityToDto(service.save(performanceDto)));
    }
}

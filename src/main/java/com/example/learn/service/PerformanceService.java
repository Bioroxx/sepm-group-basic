package com.example.learn.service;

import com.example.learn.entity.Performance;
import com.example.learn.repository.PerformanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PerformanceService
{
    private final PerformanceRepository performanceRepository;

    public Performance save(Performance performance)
    {
        return performanceRepository.save(performance);
    }

    public Performance findById(Long id)
    {
        return performanceRepository.findById(id).orElseThrow();
    }
}

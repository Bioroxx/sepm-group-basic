package com.example.learn.service;

import com.example.learn.repository.SectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SectorService
{
    private final SectorRepository sectorRepository;

    public void deleteById(Long id)
    {
        sectorRepository.deleteById(id);
    }
}

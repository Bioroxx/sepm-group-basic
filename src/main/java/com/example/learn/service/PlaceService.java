package com.example.learn.service;

import com.example.learn.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaceService
{
    private final PlaceRepository placeRepository;

    public void deleteById(Long id)
    {
        placeRepository.deleteById(id);
    }
}

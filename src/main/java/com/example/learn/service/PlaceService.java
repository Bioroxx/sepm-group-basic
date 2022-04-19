package com.example.learn.service;

import com.example.learn.entity.Place;
import com.example.learn.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaceService
{
    private final PlaceRepository placeRepository;

    public List<Place> findAllPlacesById(List<Long> placeIds)
    {
        return placeRepository.findAllById(placeIds);
    }

    public void deleteById(Long id)
    {
        placeRepository.deleteById(id);
    }
}

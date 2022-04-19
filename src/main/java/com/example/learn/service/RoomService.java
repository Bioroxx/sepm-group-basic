package com.example.learn.service;

import com.example.learn.entity.Room;
import com.example.learn.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class RoomService
{
    private final RoomRepository roomRepository;

    public Room findById(Long id)
    {
        return roomRepository.findById(id).orElseThrow();
    }

    public void deleteById(Long id)
    {
        roomRepository.deleteById(id);
    }
}

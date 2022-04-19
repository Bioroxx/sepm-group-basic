package com.example.learn.repository;

import com.example.learn.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long>
{
}

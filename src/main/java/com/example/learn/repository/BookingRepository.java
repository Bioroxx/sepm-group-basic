package com.example.learn.repository;

import com.example.learn.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long>
{
}

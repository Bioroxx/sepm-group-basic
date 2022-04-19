package com.example.learn.repository;

import com.example.learn.entity.TicketOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketOrderRepository extends JpaRepository<TicketOrder, Long>
{
}

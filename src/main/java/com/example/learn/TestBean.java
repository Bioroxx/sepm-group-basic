package com.example.learn;

import com.example.learn.entity.*;
import com.example.learn.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class TestBean
{
    private final LocationService locationService;
    private final UserService userService;
    private final PerformanceService performanceService;
    private final TicketOrderService ticketOrderService;

    @PostConstruct
    public void doSomething()
    {
        // Generate data for location
        Address address = new Address();
        address.setStreet("Hauptstrasse 1");
        address.setCity("Wien");
        address.setZipcode("1010");
        address.setCountry("Austria");


        Sector sector = new Sector();
        sector.setName("Sektor A");

        LinkedList<Place> places = new LinkedList<>();
        // Add 20 places
        for (int i = 1; i < 20; i++)
        {
            Place p = new Place();
            p.setNumber(i);
            places.add(p);
            sector.addPlace(p);
        }

        Room room = new Room();
        room.setName("Raum 1");
        room.addSector(sector);

        Location location = new Location();
        location.setName("Oper");
        location.setAddress(address);
        location.addRoom(room);
        locationService.save(location);

        // Add user
        User user = new User();
        user.setUsername("HansWurst");
        userService.save(user);

        // Add performance
        Performance performance = new Performance();
        performance.setDatetime("12-12-2022");
        performance.setRoom(room);
        performanceService.save(performance);


        // Book tickets
        log.info(ticketOrderService.purchaseTicketOrder(user, performance, places.subList(0,1)).toString());

        try
        {
            log.info(ticketOrderService.purchaseTicketOrder(user, performance, places.subList(0,2)).toString());
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
        }
    }
}

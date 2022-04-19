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


        Sector seatedSector = new Sector();
        seatedSector.setName("Sektor A (seated)");

        Sector standingSector = new Sector();
        standingSector.setName("Sektor A (seated)");

        Place standingPlace = new Place();
        standingPlace.setNumber(1);
        standingPlace.setSeatType(SeatType.STANDING);
        standingSector.addPlace(standingPlace);


        LinkedList<Place> seatPlaces = new LinkedList<>();
        // Add 20 seatPlaces
        for (int i = 1; i < 20; i++)
        {
            Place p = new Place();
            p.setNumber(i);
            p.setSeatType(SeatType.SITTING);
            seatPlaces.add(p);
            seatedSector.addPlace(p);
        }

        Room room = new Room();
        room.setName("Raum 1");
        room.addSector(seatedSector);
        room.addSector(standingSector);

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





        // TESTS


        // Book one seated place
        List<Long> placeIds = seatPlaces.subList(0,1).stream().map(place -> place.getId()).toList();

        log.info(ticketOrderService.purchaseTicketOrder(user, performance.getId(), placeIds).toString());


        // Book two seated and three standing places
        placeIds = new LinkedList<>(seatPlaces.subList(3, 5).stream().map(place -> place.getId()).toList());
        placeIds.add(standingPlace.getId());
        placeIds.add(standingPlace.getId());
        placeIds.add(standingPlace.getId());

        log.info(ticketOrderService.purchaseTicketOrder(user, performance.getId(), placeIds).toString());



        /*
        try
        {
            log.info(ticketOrderService.purchaseTicketOrder(user, performance, places.subList(0,2)).toString());
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
        }*/
    }
}

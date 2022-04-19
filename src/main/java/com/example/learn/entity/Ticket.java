package com.example.learn.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "performance_place_unique", columnNames = {"performance_id","place_id"})
})
@ToString
public class Ticket
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude private TicketOrder ticketOrder;

    @OneToOne(fetch = FetchType.EAGER)
    private Performance performance;

    @OneToOne(fetch = FetchType.EAGER)
    private Place place;
}

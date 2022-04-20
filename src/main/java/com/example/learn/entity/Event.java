package com.example.learn.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Event
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private Double duration;
    private String description;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "event")
    @ToString.Exclude
    private List<Performance> performances = new LinkedList<>();
}

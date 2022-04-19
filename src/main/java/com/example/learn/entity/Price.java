package com.example.learn.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Price
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cents;

    @ManyToOne(fetch = FetchType.LAZY)
    private Performance performance;

    @OneToOne(fetch = FetchType.LAZY)
    private Sector sector;
}

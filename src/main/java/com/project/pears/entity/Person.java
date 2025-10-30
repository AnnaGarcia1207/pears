package com.project.pears.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Person {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    private String role;
    @ManyToOne
    @JoinColumn(name= "team_id")
    private Team team;
    @ManyToOne
    @JoinColumn(name = "pair_id")
    private Pair pair;
}

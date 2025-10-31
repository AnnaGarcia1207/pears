package com.project.pears.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Pair {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "pair", cascade = CascadeType.ALL)
    private List<Person> persons;
}

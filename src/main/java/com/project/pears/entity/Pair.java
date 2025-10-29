package com.project.pears.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Pair {
    @Id
    @Generated
    private Long Id;
    private List<Person> pairs;
}

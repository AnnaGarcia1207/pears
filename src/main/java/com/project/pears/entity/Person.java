package com.project.pears.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Person {

    @Generated
    @Id
    private Long Id;
    private String Name;
    private String Role;
    private Long TeamId;
}

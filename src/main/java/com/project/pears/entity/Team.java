package com.project.pears.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Team {
    @Id
    @Generated
    private Long id;
    private String name;
}

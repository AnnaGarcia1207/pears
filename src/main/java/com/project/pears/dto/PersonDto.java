package com.project.pears.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto {

    private String id;
    @NotNull(message= "Person's name is required")
    private String name;
    @NotNull(message= "Person's role is required")
    private String role;
}

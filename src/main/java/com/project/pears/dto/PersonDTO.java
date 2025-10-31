package com.project.pears.dto;


import com.project.pears.entity.Pair;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PersonDTO {

    @NotNull(message= "Person's name is required")
    private String name;
    @NotNull(message= "Person's role is required")
    private String role;
}

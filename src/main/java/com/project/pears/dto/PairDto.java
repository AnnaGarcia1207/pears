package com.project.pears.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PairDto {
    private String id;
    private List<PersonDto> pairs;
}

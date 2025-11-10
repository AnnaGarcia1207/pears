package com.project.pears.factory;

import com.project.pears.dto.PairDto;
import com.project.pears.entity.Pair;
import org.springframework.stereotype.Component;

@Component
public class PairFactory {

    public PairDto toDto(Pair pair) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

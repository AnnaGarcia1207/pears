package com.project.pears.service;

import com.project.pears.dto.PairDto;
import com.project.pears.entity.Pair;
import com.project.pears.exception.PairNotFoundException;
import com.project.pears.factory.PairFactory;
import com.project.pears.repository.PairRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PairService {

    private final PairRepository pairRepository;
    private final PairFactory factory;
    public PairDto getById(String id) {

        Pair pair = pairRepository.findById(Long.valueOf(id))
                .orElseThrow( () -> new PairNotFoundException("Pair with cannot be found with ID: " + id));
        return factory.toDto(pair);

    }

    public List<PairDto> getAllPairs() {
        return pairRepository.findAll().stream().map(factory::toDto).toList();
    }

    @Transactional
    public PairDto create(PairDto dto) {
        Pair entity = factory.toEntity(dto);

        Pair createdEntity = pairRepository.save(entity);
        return factory.toDto(createdEntity);
    }

    public PairDto update(String id, PairDto dto) {
        throw new UnsupportedOperationException("Not yet Implemented");
    }

    public void delete(String id) {
        throw new UnsupportedOperationException("Not yet Implemented");
    }

}

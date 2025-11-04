package com.project.pears.controller;

import com.project.pears.dto.PairDto;
import com.project.pears.service.PairService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pairs")
@RequiredArgsConstructor
public class PairController {

    private final PairService pairService;

    @GetMapping()
    public ResponseEntity<PairDto> getById(@RequestParam String id) {
        PairDto dto = pairService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping()
    public ResponseEntity<List<PairDto>> getPairs() {
        List<PairDto> dtos = pairService.getAllPairs();
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<PairDto> create(@RequestBody @Valid PairDto pairDto) {
        PairDto created = pairService.create(pairDto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PairDto> update(@RequestBody @Valid PairDto pairDto,
                          @PathVariable String id) {
        PairDto updated = pairService.update(id, pairDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        pairService.delete(id);
        return ResponseEntity.noContent().build();
    }


}

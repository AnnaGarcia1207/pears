package com.project.pears.controller;

import com.project.pears.dto.PairDto;
import com.project.pears.service.PairService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public PairDto getPairs() {
        throw new UnsupportedOperationException("Not yet Implemented");
    }

    @PostMapping
    public PairDto create(@RequestBody @Valid PairDto pairDto) {
        throw new UnsupportedOperationException("Not yet Implemented");
    }

    @PutMapping
    public PairDto update(@RequestBody @Valid PairDto pairDto) {
        throw new UnsupportedOperationException("Not yet Implemented");
    }

    @DeleteMapping
    public void delete(@PathVariable String id) {
        throw new UnsupportedOperationException("Not yet Implemented");
    }


}

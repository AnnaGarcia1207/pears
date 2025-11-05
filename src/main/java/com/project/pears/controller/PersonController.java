package com.project.pears.controller;

import com.project.pears.dto.PersonDto;
import com.project.pears.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;


    @GetMapping()
    public ResponseEntity<PersonDto> getById(@RequestParam String id) {
        PersonDto dto = personService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PersonDto> create(@RequestBody @Valid PersonDto personDTO) {
        PersonDto dto = personService.create(personDTO);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> update(@RequestBody @Valid PersonDto personDTO,
                                            @PathVariable String id) {
        PersonDto dto = personService.update(id, personDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        personService.delete(id);
        return ResponseEntity.noContent().build(); // returns 204 Standard REST
    }




}

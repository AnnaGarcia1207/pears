package com.project.pears.controller;

import com.project.pears.dto.PersonDTO;
import com.project.pears.entity.Person;
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
    public ResponseEntity<PersonDTO> getById(@RequestParam Long id) {
        PersonDTO dto = personService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> create(@RequestBody @Valid PersonDTO personDTO) {
        PersonDTO dto = personService.create(personDTO);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> update(@RequestBody @Valid PersonDTO personDTO, @PathVariable String id) {
        PersonDTO dto = personService.update(id, personDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        personService.delete(id);
        return ResponseEntity.noContent().build(); // returns 204 Standard REST
    }




}

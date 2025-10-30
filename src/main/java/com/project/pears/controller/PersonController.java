package com.project.pears.controller;

import com.project.pears.entity.Person;
import com.project.pears.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;


    @GetMapping()
    public ResponseEntity<Person> getById(@RequestParam Long id) {
        Person person = personService.getById(id);
        return ResponseEntity.ok(person);
    }
}

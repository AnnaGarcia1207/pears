package com.project.pears.service;

import com.project.pears.entity.Person;
import com.project.pears.exception.PersonNotFoundException;
import com.project.pears.repository.PersonRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person getById(Long id) {
        return personRepository.findById(id)
                .orElseThrow( () -> new PersonNotFoundException("Person with cannot be found with ID: " + id));
    }
}

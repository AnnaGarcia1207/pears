package com.project.pears.service;

import com.project.pears.dto.PersonDTO;
import com.project.pears.entity.Person;
import com.project.pears.exception.PersonNotFoundException;
import com.project.pears.factory.PersonFactory;
import com.project.pears.repository.PersonRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonFactory factory;

    public PersonDTO getById(String id) {
        Person person =  personRepository.findById(Long.valueOf(id))
                .orElseThrow( () -> new PersonNotFoundException("Person with cannot be found with ID: " + id));
        return factory.toDTO(person);
    }

    public PersonDTO create(@Valid PersonDTO personDTO) {
        throw new UnsupportedOperationException("Operation is not yet implemented ");
    }

    public PersonDTO update(String id, @Valid PersonDTO personDTO) {
        throw new UnsupportedOperationException("Operation is not yet implemented");
    }

    public void delete(String id) {
        throw new UnsupportedOperationException("Operation is not yet implemented");
    }
}

package com.project.pears.factory;

import com.project.pears.dto.PersonDTO;
import com.project.pears.entity.Person;


public class PersonFactory {

    public PersonDTO toDTO(Person person) {
        return PersonDTO.builder()
                .name(person.getName())
                .role(person.getRole())
                .build();
    }

    public Person toEntity(PersonDTO personDTO) {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setRole(personDTO.getRole());
        // person.setTeam(); this will get set in the service per user session.

        return person;
    }
}

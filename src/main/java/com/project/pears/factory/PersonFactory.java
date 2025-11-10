package com.project.pears.factory;

import com.project.pears.dto.PersonDto;
import com.project.pears.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonFactory {

    public PersonDto toDto(Person person) {
        return PersonDto.builder()
                .name(person.getName())
                .role(person.getRole())
                .build();
    }

    public Person toEntity(PersonDto personDTO) {
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setRole(personDTO.getRole());
        // person.setTeam(); this will get set in the service per user session.

        return person;
    }
}

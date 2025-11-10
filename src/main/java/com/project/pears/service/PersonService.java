package com.project.pears.service;

import com.project.pears.dto.PersonDto;
import com.project.pears.entity.Person;
import com.project.pears.entity.Team;
import com.project.pears.exception.PersonNotFoundException;
import com.project.pears.factory.PersonFactory;
import com.project.pears.repository.PersonRepository;

import com.project.pears.repository.TeamRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final TeamRepository teamRepository;
    private final PersonFactory factory;


    public PersonDto getById(String id) {
        Person person =  personRepository.findById(Long.valueOf(id))
                .orElseThrow( () -> new PersonNotFoundException("Person with cannot be found with ID: " + id));
        return factory.toDto(person);
    }

    @Transactional
    public PersonDto create(PersonDto personDTO) {
        Person entity = factory.toEntity(personDTO);

        entity.setTeam(getTempTeam());
        Person createdEntity = personRepository.save(entity);
        return factory.toDto(createdEntity);
    }

    public PersonDto update(String id, PersonDto personDTO) {
        Person person =  personRepository.findById(Long.valueOf(id))
                .orElseThrow( () -> new PersonNotFoundException("Person with cannot be found with ID: " + id));

        person.setName(personDTO.getName());
        person.setRole(personDTO.getRole());
        Person updatedPerson = personRepository.save(person);
        return factory.toDto(updatedPerson);
    }

    public void delete(String id) {
        Person person =  personRepository.findById(Long.valueOf(id))
                .orElseThrow( () -> new PersonNotFoundException("Person with cannot be found with ID: " + id));
        personRepository.delete(person);
    }

    // Temporary
    private Team getTempTeam() {
        Team tempTeam = teamRepository.findById(1L)
                .orElseGet(() -> {
                    Team t = new Team();
                    t.setName("TEMP_TEAM");
                    return teamRepository.save(t);
                });
        return tempTeam;
    }
}

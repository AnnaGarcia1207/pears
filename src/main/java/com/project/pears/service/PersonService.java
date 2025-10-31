package com.project.pears.service;

import com.project.pears.dto.PersonDTO;
import com.project.pears.entity.Person;
import com.project.pears.entity.Team;
import com.project.pears.exception.PersonNotFoundException;
import com.project.pears.factory.PersonFactory;
import com.project.pears.repository.PersonRepository;

import com.project.pears.repository.TeamRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final TeamRepository teamRepository;
    private final PersonFactory factory;


    public PersonDTO getById(String id) {
        Person person =  personRepository.findById(Long.valueOf(id))
                .orElseThrow( () -> new PersonNotFoundException("Person with cannot be found with ID: " + id));
        return factory.toDTO(person);
    }

    @Transactional
    public PersonDTO create(@Valid PersonDTO personDTO) {
        Person entity = factory.toEntity(personDTO);

        entity.setTeam(teamFinder());
        Person createdEntity = personRepository.save(entity);
        return factory.toDTO(createdEntity);
    }

    public PersonDTO update(String id, @Valid PersonDTO personDTO) {
        Person person =  personRepository.findById(Long.valueOf(id))
                .orElseThrow( () -> new PersonNotFoundException("Person with cannot be found with ID: " + id));

        person.setName(personDTO.getName());
        person.setRole(personDTO.getRole());
        Person updatedPerson = personRepository.save(person);
        return factory.toDTO(updatedPerson);
    }

    public void delete(String id) {
        Person person =  personRepository.findById(Long.valueOf(id))
                .orElseThrow( () -> new PersonNotFoundException("Person with cannot be found with ID: " + id));
        personRepository.delete(person);
    }

    // Temporary
    private Team teamFinder() {
        Team tempTeam = teamRepository.findById(1L)
                .orElseGet(() -> {
                    Team t = new Team();
                    t.setName("TEMP_TEAM");
                    return teamRepository.save(t);
                });
        return tempTeam;
    }
}

package com.project.pears.service;

import com.project.pears.dto.PersonDto;
import com.project.pears.entity.Person;
import com.project.pears.entity.Team;
import com.project.pears.factory.PersonFactory;
import com.project.pears.repository.PersonRepository;
import com.project.pears.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository mockPersonRepository;
    @Mock
    private PersonFactory mockPersonFactory;
    @Mock
    private TeamRepository mockTeamRepository;

    @InjectMocks
    private PersonService subject;

    private final String id = "1";
    private final String name = "Jane Doe";
    private final String role = "Developer";

    @Test
    void getById() {
        Person person = new Person();
        person.setId(Long.valueOf(id));
        person.setName(name);
        person.setRole(role);

        PersonDto expected = PersonDto.builder()
                .id(id)
                .name(name)
                .role(role)
                .build();

        when(mockPersonRepository.findById(any(Long.class))).thenReturn(Optional.of(person));
        when(mockPersonFactory.toDTO(any(Person.class))).thenReturn(expected);

        PersonDto actual = subject.getById(id);

        assertEquals(id, actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getRole(), actual.getRole());
    }

    @Test
    void create() {
        PersonDto input = PersonDto.builder()
                .name(name)
                .role(role)
                .build();

        Person inputEntity = new Person();
        inputEntity.setName(name);
        inputEntity.setRole(role);

        PersonDto expectedDto = PersonDto.builder()
                .id(id)
                .name(name)
                .role(role)
                .build();

        Team team = new Team();
        team.setName("TEAM_A");
        team.setId(1L);

        when(mockPersonFactory.toEntity(any(PersonDto.class))).thenReturn(inputEntity);
        // set the ID prior mocking of save
        inputEntity.setId(Long.valueOf(id));


        when(mockTeamRepository.findById(any(Long.class))).thenReturn(Optional.of(team));
        when(mockPersonRepository.save(any(Person.class))).thenReturn(inputEntity);



        when(mockPersonFactory.toDTO(any(Person.class))).thenReturn(expectedDto);

        PersonDto actual = subject.create(input);

        assertNotNull(actual);
        assertEquals(id, actual.getId());
        verify(mockPersonRepository, times(1)).save(any(Person.class));

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}
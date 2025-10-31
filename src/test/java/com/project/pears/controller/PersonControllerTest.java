package com.project.pears.controller;

import com.project.pears.dto.PersonDTO;
import com.project.pears.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Arrange -> Act -> Assert for unit tests
@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

    @Mock
    private PersonService mockPersonService; // mocks the dependency

    @InjectMocks // inject mockPersonService into the controller
    private PersonController subject;

    private final String id = "1";
    private final String name = "John Doe";
    private final String role = "Developer";

    @BeforeEach
    void setUp() {

    }

    @Test
    void getById() {
        PersonDTO personDTO = PersonDTO.builder()
                .id(id)
                .name(name)
                .role(role)
                .build();
        // Arrange
        when(mockPersonService.getById(id)).thenReturn(personDTO);
        // Act
        ResponseEntity<PersonDTO> response = subject.getById(id);

        // Assert
        assertNotNull(response.getBody());
        assertEquals(name, response.getBody().getName());
        assertEquals(role, response.getBody().getRole());
        verify(mockPersonService).getById(id);
    }

    @Test
    void create() {
        PersonDTO dto = PersonDTO.builder()
                .name(name)
                .role(role)
                .build();

        // Arrange
        when(mockPersonService.create(any(PersonDTO.class))).thenReturn(dto);

        // Act
        ResponseEntity<PersonDTO> response = subject.create(dto);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        PersonDTO actual = response.getBody();
        assertNotNull(actual.getId());
        assertEquals(name, actual.getName());
        assertEquals(role, actual.getRole());
    }

    @Test
    void update() {
        String newRole = "QA";
        PersonDTO updatedDto = PersonDTO.builder().name(name).role(newRole).build();
        when(mockPersonService.update(anyString(), any(PersonDTO.class))).thenReturn(updatedDto);

        ResponseEntity<PersonDTO> response = subject.update(updatedDto, id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(newRole, response.getBody().getRole());
    }

    @Test
    void delete() {

        doNothing().when(mockPersonService).delete(anyString());
        ResponseEntity<Void> response = subject.delete(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(mockPersonService).delete(id);
    }
}
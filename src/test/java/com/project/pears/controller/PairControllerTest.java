package com.project.pears.controller;

import com.project.pears.dto.PairDto;
import com.project.pears.dto.PersonDto;
import com.project.pears.service.PairService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PairControllerTest {

    @Mock
    private PairService mockPairService;

    @InjectMocks
    private PairController subject;

    @Test
    void getById() {
        String id  = "1";
        PersonDto pairOne = PersonDto.builder().name("Anna").build();
        PersonDto pairTwo = PersonDto.builder().name("Andrey").build();

        PairDto expected = PairDto.builder()
                .id(id)
                .pairs(List.of(pairOne, pairTwo))
                .build();
        // Arrange
        when(mockPairService.getById(id)).thenReturn(expected);
        // Act
        ResponseEntity<PairDto> response = subject.getById(id);
        // Assert
        assertNotNull(response.getBody());
        assertEquals(id, response.getBody().getId());
    }

    @Test
    void getAllPairs() {
        String id  = "1";
        PersonDto pairOne = PersonDto.builder().name("Anna").build();
        PersonDto pairTwo = PersonDto.builder().name("Andrey").build();

        PairDto expected = PairDto.builder()
                .id(id)
                .pairs(List.of(pairOne, pairTwo))
                .build();
        // Arrange
        when(mockPairService.getAllPairs()).thenReturn(List.of(expected));
        // Act
        ResponseEntity<List<PairDto>> response = subject.getPairs();
        // Assert
        assertNotNull(response.getBody());
        PairDto actual = response.getBody().getFirst();
        assertEquals(id, actual.getId());

    }

    @Test
    void create() {

        String id  = "1";
        PersonDto pairOne = PersonDto.builder().name("Anna").build();
        PersonDto pairTwo = PersonDto.builder().name("Andrey").build();

        PairDto expected = PairDto.builder()
                .id(id)
                .pairs(List.of(pairOne, pairTwo))
                .build();
        // Arrange
        when(mockPairService.create(any(PairDto.class))).thenReturn(expected);
        // Act
        PairDto dto = PairDto.builder()
                .pairs(List.of(pairOne, pairTwo))
                .build();
        ResponseEntity<PairDto> response = subject.create(dto);
        // Assert
        assertNotNull(response.getBody());
        PairDto actual = response.getBody();
        assertNotNull(actual.getId());
    }

    @Test
    void updateTest() {
        String id  = "1";
        PersonDto pairOne = PersonDto.builder().name("Anna").build();

        PairDto updatedDto = PairDto.builder()
                .id(id)
                .pairs(List.of(pairOne))
                .build();
        // Arrange
        when(mockPairService.update(anyString(), any(PairDto.class))).thenReturn(updatedDto);
        // Act
        ResponseEntity<PairDto> response = subject.update(updatedDto, id);
        //assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        PairDto actual = response.getBody();
        assertEquals(1, actual.getPairs().size());
        assertEquals(id, actual.getId());
    }

    @Test
    void delete() {
        String id  = "1";
        doNothing().when(mockPairService).delete(anyString());
        ResponseEntity<Void> response = subject.delete(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(mockPairService).delete(id);
    }


}
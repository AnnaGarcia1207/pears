package com.project.pears.controller;

import com.project.pears.dto.PairDto;
import com.project.pears.service.PairService;
import org.apache.coyote.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PairControllerTest {

    @Mock
    private PairService mockPairService;

    @InjectMocks
    private PairController subject;

    @Test
    void getById() {

        ResponseEntity<PairDto> response = subject.getById("1L");
        assertNotNull(response);
    }

}
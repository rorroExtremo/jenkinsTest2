package com.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DummyServiceTest {

    private DummyServiceToTestJunit service;

    @BeforeEach
    void setUp() {
        service = new DummyServiceToTestJunit();
    }

    @Test
    void hadleSomeDummyLogic_shouldReturnFive() {
        int result = service.hadleSomeDummyLogic();

        assertEquals(5, result);
    }
}

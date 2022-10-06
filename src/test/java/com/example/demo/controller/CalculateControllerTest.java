package com.example.demo.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CalculateControllerTest {

    @Autowired
    private CalculateController calculateController;

    @Test
    @DisplayName("Checks if controller is not Null")
    void calculateControllerLoads0() {

        assertThat(calculateController).isNotNull();

    }

}

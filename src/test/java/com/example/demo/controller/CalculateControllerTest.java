package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.servlet.http.HttpServletRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CalculateControllerTest {
    @Test
    void calculateControllerLoads1() {

        CalculateController calculateController = new CalculateController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("averageSalary")).thenReturn("100000");
        when(request.getParameter("startDay")).thenReturn("2022-10-04");
        when(request.getParameter("daysRequest")).thenReturn("14");
        String cash = calculateController.calculate(request);
        assertEquals("47781,57", cash);
    }

    @Test
    void calculateControllerLoads2() {

        CalculateController calculateController = new CalculateController();
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("averageSalary")).thenReturn("100000");
        when(request.getParameter("startDay")).thenReturn("2022-10-04");
        when(request.getParameter("daysRequest")).thenReturn("0");
        String cash = calculateController.calculate(request);
        assertEquals("Error: Forbidden vacation days = 0", cash);
    }
}

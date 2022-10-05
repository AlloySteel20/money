package com.example.demo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VacationPaymentTest {

    @Test
    public void vacationPaymentRequestTest1() throws RuntimeException {
        VacationPayment vacationPayment = new VacationPayment(100000, LocalDate.parse("2022-10-04"), 10);
        assertEquals("34129,69", vacationPayment.getSum());
    }
}

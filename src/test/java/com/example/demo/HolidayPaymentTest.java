package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class HolidayPaymentTest {

    @Test
    public void holidayPaymentRequestTest1() throws RuntimeException{
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            HolidayPayment holidayPayment = new HolidayPayment(100000, LocalDate.parse("2022-10-04"),0);
        }, "RuntimeException was expected");

        Assertions.assertEquals("Error: Forbidden vacation days = 0", thrown.getMessage());
    }
}

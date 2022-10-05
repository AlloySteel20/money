package com.example.demo.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static com.example.demo.utils.DateUtil.getDaysWithoutHolidays;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DateUtilTest {
    @Test
    void contextLoads1(){
        LocalDate startDate = LocalDate.parse("2022-10-04");
        int endDate = 7;
        assertEquals(7, getDaysWithoutHolidays(startDate, endDate));
    }

    @Test
    void contextLoads2(){
        LocalDate startDate = LocalDate.parse("2022-01-01");
        int endDate = 5;
        assertEquals(0, getDaysWithoutHolidays(startDate, endDate));
    }

    @Test
    void contextLoads3(){
        LocalDate startDate = LocalDate.parse("2022-01-01");
        int endDate = 13;
        assertEquals(5, getDaysWithoutHolidays(startDate, endDate));
    }
}

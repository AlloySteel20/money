package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static com.example.demo.DateUtil.GetDaysWithoutHolidays;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DateUtilTest {
    @Test
    void contextLoads1() throws Exception {
        LocalDate startDate = LocalDate.parse("2022-10-04");
        int endDate = 7;
        assertEquals(7, GetDaysWithoutHolidays(startDate, endDate));
    }

    @Test
    void contextLoads2() throws Exception {
        LocalDate startDate = LocalDate.parse("2022-01-01");
        int endDate = 5;
        assertEquals(0, GetDaysWithoutHolidays(startDate, endDate));
    }

    @Test
    void contextLoads3() throws Exception {
        LocalDate startDate = LocalDate.parse("2022-01-01");
        int endDate = 13;
        assertEquals(5, GetDaysWithoutHolidays(startDate, endDate));
    }
}

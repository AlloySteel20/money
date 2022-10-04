package com.example.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class DateUtil {
    public static int GetDaysWithoutHolidays(LocalDate startDate, int range) throws Exception {

        if (range == 0) {
            throw new Exception("Error: Forbidden vacation days = 0");
        }
        LocalDate endDate = startDate.plusDays(range);
        List<LocalDate> listOfDates = startDate.datesUntil(endDate).collect(Collectors.toList());
        int days = 0;

        for (LocalDate localDate : listOfDates) {
            if (!isHoliday(localDate)) {
                days++;
            }
        }


        return days;
    }

    // Holidays check

    private static boolean isHoliday(LocalDate localDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd");
        String formattedDate = localDate.format(formatter);

        String[] holidays = {"01.01", "01.02", "01.03", "01.04", "01.05", "01.06", "01.07", "01.08", "02.23", "03.08", "05.01", "05.09", "06.12", "11.04"};
        for (String day : holidays) {
            if (formattedDate.equals(day)) {
                return true;
            }
        }
        return false;

    }
}

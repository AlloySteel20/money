package com.example.demo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class DateUtil {
    public static int GetWorkingDays(LocalDate startDate, int range) throws Exception {

        if (range == 0) throw new Exception("Error: Forbidden vacation days = 0"); //RuntimeException("Error: Forbidden vacation days");
        LocalDate endDate = startDate.plusDays(range);
        List<LocalDate> listOfDates = startDate.datesUntil(endDate).collect(Collectors.toList());
        int days = 0;

        for (LocalDate localDate : listOfDates) {
            if (localDate.getDayOfWeek() != DayOfWeek.SUNDAY && localDate.getDayOfWeek() != DayOfWeek.SATURDAY && !isHoliday(localDate)) {
                days++;
            }
        }


        return days;
    }

    // Holidays check

    private static boolean isHoliday(LocalDate localDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd"); //"dd/MM/yyyy"
        String formattedDate = localDate.format(formatter);

        String[] holidays = {"01.01", "01.02", "01.03", "01.04", "01.05", "01.06", "01.07", "01.08", "02.22", "02.23", "03.05", "03.07", "03.08", "05.01", "05.02", "05.03", "05.09", "05.10", "06.12", "06.13", "11.03", "11.04"};
        for (String day : holidays) {
            if (formattedDate.equals(day)) {
                return true;
            }
        }
        return false;

    }
}

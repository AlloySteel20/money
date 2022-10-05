package com.example.demo.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceUtil {

    static final double AVERAGE_DAYS_IN_MONTH = 29.3;
    static final String[] holidays = {"01.01", "01.02", "01.03", "01.04", "01.05", "01.06", "01.07", "01.08", "02.23", "03.08", "05.01", "05.09", "06.12", "11.04"};

    public static int getDaysWithoutHolidays(LocalDate startDate, int range) throws RuntimeException {

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

        for (String day : holidays) {
            if (formattedDate.equals(day)) {
                return true;
            }
        }
        return false;

    }

    public static String getHolidayPayment(double averageSalary, LocalDate startDay, int daysRequest) {
        return String.format("%.2f", (averageSalary / AVERAGE_DAYS_IN_MONTH) * getDaysWithoutHolidays(startDay, daysRequest));
    }

}

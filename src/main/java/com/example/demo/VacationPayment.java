package com.example.demo;

import com.example.demo.utils.DateUtil;

import java.time.LocalDate;
import java.util.Objects;

public class VacationPayment {

    private static final double AVERAGE_DAYS_IN_MONTH = 29.3;

    private final double averageSalary;
    private final LocalDate startDate;
    private final int daysRequest;

    public VacationPayment(double averageSalary, LocalDate startDate, int daysRequest) {
        this.averageSalary = averageSalary;
        this.startDate = startDate;
        this.daysRequest = daysRequest;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public int getDaysRequest() {
        return daysRequest;
    }

    public String getSum() {
        int vacationDays = DateUtil.getDaysWithoutHolidays(startDate, daysRequest);
        return String.format("%.2f", (averageSalary / AVERAGE_DAYS_IN_MONTH) * vacationDays);
    }

    public String getSumWithoutHolidays() {
        return String.format("%.2f", (averageSalary / AVERAGE_DAYS_IN_MONTH) * daysRequest);
    }

    @Override
    public String toString() {
        return "HolidayPaymentRequest{" +
                "averageSalary=" + averageSalary +
                ", startDay=" + startDate +
                ", daysRequest=" + daysRequest +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacationPayment that = (VacationPayment) o;
        return Double.compare(that.averageSalary, averageSalary) == 0
                && daysRequest == that.daysRequest
                && startDate.equals(that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(averageSalary, startDate, daysRequest);
    }
}

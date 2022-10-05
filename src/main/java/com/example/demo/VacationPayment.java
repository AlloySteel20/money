package com.example.demo;

import com.example.demo.utils.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

public class VacationPayment {

    private static final double AVERAGE_DAYS_IN_MONTH = 29.3;

    private final double averageSalary;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private final LocalDate startDay;
    private final int daysRequest;

    public VacationPayment(double averageSalary, LocalDate startDay, int daysRequest) {
        this.averageSalary = averageSalary;
        this.startDay = startDay;
        this.daysRequest = daysRequest;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public int getDaysRequest() {
        return daysRequest;
    }

    public String getSum() {
        return String.format("%.2f", (averageSalary / AVERAGE_DAYS_IN_MONTH) * DateUtil.getDaysWithoutHolidays(startDay, daysRequest));
    }

    @Override
    public String toString() {
        return "HolidayPaymentRequest{" +
                "averageSalary=" + averageSalary +
                ", startDay=" + startDay +
                ", daysRequest=" + daysRequest +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacationPayment that = (VacationPayment) o;
        return Double.compare(that.averageSalary, averageSalary) == 0 && daysRequest == that.daysRequest && startDay.equals(that.startDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(averageSalary, startDay, daysRequest);
    }
}

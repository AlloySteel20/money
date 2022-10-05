package com.example.demo;

import com.example.demo.utils.ServiceUtil;
import java.time.LocalDate;

public class HolidayPayment {


    private double averageSalary;
    private LocalDate startDay;
    private int daysRequest;

    public HolidayPayment(double averageSalary, LocalDate startDay, int daysRequest) {
        setAverageSalary(averageSalary);
        setStartDay(startDay);
        setDaysRequest(daysRequest);
    }

    private void setAverageSalary(double averageSalary) {
        if (averageSalary == 0) {
            throw new RuntimeException("Error: Forbidden average salary = 0");
        }
        this.averageSalary = averageSalary;
    }

    private void setStartDay(LocalDate startDay) {
        if (startDay == null) {
            throw new RuntimeException("Error: start date is null");
        }
        this.startDay = startDay;
    }

    private void setDaysRequest(int daysRequest) {
        if (daysRequest == 0) {
            throw new RuntimeException("Error: Forbidden vacation days = 0");
        }
        this.daysRequest = daysRequest;
    }

    private double getAverageSalary() {
        return averageSalary;
    }

    private LocalDate getStartDay() {
        return startDay;
    }

    private int getDaysRequest() {
        return daysRequest;
    }

    public String getSum() {
        return ServiceUtil.getHolidayPayment(getAverageSalary(), getStartDay(), getDaysRequest());
    }

    @Override
    public String toString() {
        return "HolidayPaymentRequest{" +
                "averageSalary=" + averageSalary +
                ", startDay=" + startDay +
                ", daysRequest=" + daysRequest +
                '}';
    }
}

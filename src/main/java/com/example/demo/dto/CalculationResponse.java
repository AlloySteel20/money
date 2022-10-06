package com.example.demo.dto;

import java.util.Objects;

public class CalculationResponse {
    private double vacationMoney;

    public CalculationResponse(double vacationMoney) {
        this.vacationMoney = vacationMoney;
    }

    public void setVacationMoney(double vacationMoney) {
        this.vacationMoney = vacationMoney;
    }

    public double getVacationMoney() {
        return vacationMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculationResponse that = (CalculationResponse) o;
        return Double.compare(that.vacationMoney, vacationMoney) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vacationMoney);
    }
}

package com.example.demo.dto;

import java.util.Objects;

public class CalculationResponseDto {
    private String vacationMoney;

    public CalculationResponseDto(String vacationMoney) {
        this.vacationMoney = vacationMoney;
    }

    public void setVacationMoney(String vacationMoney) {
        this.vacationMoney = vacationMoney;
    }

    public String getVacationMoney() {
        return vacationMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculationResponseDto that = (CalculationResponseDto) o;
        return vacationMoney.equals(that.vacationMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vacationMoney);
    }
}

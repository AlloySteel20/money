package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class CalculationResponse {
    private BigDecimal vacationMoney;

    public CalculationResponse(BigDecimal vacationMoney) {
        this.vacationMoney = vacationMoney;
    }

    public void setVacationMoney(BigDecimal vacationMoney) {
        this.vacationMoney = vacationMoney;
    }

    public BigDecimal getVacationMoney() {
        return vacationMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculationResponse that = (CalculationResponse) o;
        return vacationMoney.equals(that.vacationMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vacationMoney);
    }
}

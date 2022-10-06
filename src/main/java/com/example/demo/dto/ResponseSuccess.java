package com.example.demo.dto;

import java.util.Objects;

public class ResponseSuccess {
    private final String vacationMoney;

    public ResponseSuccess(String vacationMoney) {
        this.vacationMoney = vacationMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseSuccess that = (ResponseSuccess) o;
        return vacationMoney.equals(that.vacationMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vacationMoney);
    }
}

package com.example.demo.dto;

import java.util.Objects;

public class ResponseError {
    private String error;

    public ResponseError(String error) {
        this.error = error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseError that = (ResponseError) o;
        return error.equals(that.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(error);
    }
}

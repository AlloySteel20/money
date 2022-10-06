package com.example.demo.controller;

import com.example.demo.VacationPayment;
import com.example.demo.dto.CalculationResponse;
import com.example.demo.dto.ErrorResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@RestController
@Validated
public class CalculateController {


    @GetMapping("/calculate")
    public ResponseEntity<CalculationResponse> calculate(
        @RequestParam("averageSalary") @NotNull @Min(1) double averageSalary,
        @RequestParam(value = "startDate", required = false)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
        @RequestParam("daysRequest") @NotNull @Min(1) int daysRequest
    ) {
        var vacationPayment = new VacationPayment(averageSalary, startDate, daysRequest);
        var calculationResponseDto = new CalculationResponse(vacationPayment.getSum());
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(calculationResponseDto);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleRuntimeError(final Exception e) {
        return getErrorResponse(e.getMessage());

    }

    private ResponseEntity<ErrorResponse> getErrorResponse(String errorMessage) {
        var responseError = new ErrorResponse(errorMessage);
        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(responseError);
    }

}

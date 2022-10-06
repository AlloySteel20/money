package com.example.demo.controller;

import com.example.demo.VacationPayment;
import org.json.JSONObject;
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
    public ResponseEntity<String> calculate(@RequestParam("averageSalary") @NotNull @Min(1) double averageSalary,
                                            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @NotNull LocalDate startDate,
                                            @RequestParam("daysRequest") @NotNull @Min(2) int daysRequest
    ) {
        var vacationPayment = new VacationPayment(averageSalary, startDate, daysRequest);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new JSONObject().put("VacationMoney", vacationPayment.getSum()).toString());
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handleRuntimeError(final RuntimeException e) {
        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(new JSONObject().put("Error:", e.getMessage()).toString());
    }

}

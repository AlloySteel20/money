package com.example.demo.controller;

import com.example.demo.VacationPayment;
import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@RestController
@Validated
public class CalculateController {


    @GetMapping("/calculate")
    public ResponseEntity<String> calculate(@RequestParam("averageSalary") @NotNull @Min(1) double averageSalary,
                                            @RequestParam(value = "startDate", required = false)
                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                            @RequestParam("daysRequest") @NotNull @Min(1) int daysRequest
    ) {
        var vacationPayment = new VacationPayment(averageSalary, startDate, daysRequest);
        String response = new JSONObject().put("VacationMoney", vacationPayment.getSum()).toString();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handleRuntimeError(final RuntimeException e) {
        String response = new JSONObject().put("Error:", e.getMessage()).toString();
        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(response);
    }

}

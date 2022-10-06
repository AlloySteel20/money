package com.example.demo.controller;

import com.example.demo.VacationPayment;
import com.example.demo.dto.ResponseError;
import com.example.demo.dto.ResponseSuccess;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    ) throws JsonProcessingException {
        var vacationPayment = new VacationPayment(averageSalary, startDate, daysRequest);
        var responseSuccess = new ResponseSuccess(vacationPayment.getSum());
        var mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        var response = mapper.writeValueAsString(responseSuccess);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handleRuntimeError(final RuntimeException e) throws JsonProcessingException {
        var ResponseError = new ResponseError(e.getMessage());
        var mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        var response = mapper.writeValueAsString(ResponseError);
        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleRuntimeError(final Exception e) throws JsonProcessingException {
        var ResponseError = new ResponseError(e.getMessage());
        var mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        var response = mapper.writeValueAsString(ResponseError);
        return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body(response);
    }

}

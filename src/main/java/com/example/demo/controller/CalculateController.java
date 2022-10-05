package com.example.demo.controller;

import com.example.demo.HolidayPayment;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class CalculateController {

    @GetMapping("/calculate")
    public String calculate(@RequestParam double averageSalary, @RequestParam("startDay") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDay, @RequestParam int daysRequest) {
        try {
           return new HolidayPayment(averageSalary,startDay,daysRequest).getSum();
        } catch (RuntimeException e) {
            return e.getMessage();
        }

    }
}

package com.example.demo.controller;

import com.example.demo.VacationPayment;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {

    @GetMapping("/calculate")
    public ResponseEntity<String> calculate(@Validated() @ModelAttribute("VacationPayment") VacationPayment vacationPayment) {
        try {
            if (vacationPayment.getAverageSalary() == 0) {
                throw new RuntimeException("Average salary should not be equal 0");
            }
            if (vacationPayment.getDaysRequest() <= 1) {
                throw new RuntimeException("Vacation period should not be equal or less than 1");
            }
            return new ResponseEntity<>(new JSONObject().put("VacationMoney", vacationPayment.getSum()).toString(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new JSONObject().put("Error:", e.getMessage()).toString(), HttpStatus.BAD_REQUEST);
        }

    }
}

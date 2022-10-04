package com.example.demo.controller;

import com.example.demo.DateUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.time.LocalDate;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

@RestController
public class CalculateController {
    @GetMapping("/calculate")
    public String calculate(HttpServletRequest request){
        try {
            String averageSalary = request.getParameter("averageSalary");
            String dateRequest = request.getParameter("dateRequest");
            String daysRequest = request.getParameter("daysRequest");
            int days = DateUtil.GetWorkingDays(LocalDate.parse(dateRequest), parseInt(daysRequest));
            return String.format("%.2f",(parseDouble(averageSalary)/29.3) * days);
        }
        catch (Exception e){
            return e.getMessage();
        }

    }
}

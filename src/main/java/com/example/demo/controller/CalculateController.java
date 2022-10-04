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
    final  double AVERAGE_MONTH_DAYS_IN_YEAR = 29.3;

    @GetMapping("/calculate")
    public String calculate(HttpServletRequest request){
        try {
            double averageSalary = parseDouble(request.getParameter("averageSalary"));
            LocalDate dateRequest = LocalDate.parse(request.getParameter("dateRequest"));
            int daysRequest =  parseInt(request.getParameter("daysRequest"));
            int workingDays = DateUtil.GetWorkingDays(dateRequest,daysRequest);
            return String.format("%.2f",(averageSalary/AVERAGE_MONTH_DAYS_IN_YEAR) * workingDays);
        }
        catch (Exception e){
            return e.getMessage();
        }

    }
}

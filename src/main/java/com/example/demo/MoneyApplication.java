package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoneyApplication {

	public static void main(String[] args)  {
		SpringApplication.run(MoneyApplication.class, args);
		//EXAMPLE: http://localhost:8080/calculate?averageSalary=100000&dateRequest=2022-10-04&daysRequest=14
	}

}

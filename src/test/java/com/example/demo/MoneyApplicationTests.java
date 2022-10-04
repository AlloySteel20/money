package com.example.demo;

import com.example.demo.controller.CalculateController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

import static com.example.demo.DateUtil.GetDaysWithoutHolidays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class MoneyApplicationTests {

	@Test
	void contextLoads1() throws Exception {
		LocalDate startDate = LocalDate.parse("2022-10-04");
		int endDate = 7;
		assertEquals(7, GetDaysWithoutHolidays(startDate,endDate));
	}
	@Test
	void contextLoads2() throws Exception {
		LocalDate startDate = LocalDate.parse("2022-01-01");
		int endDate = 5;
		assertEquals(0, GetDaysWithoutHolidays(startDate,endDate));
	}
	@Test
	void contextLoads3() throws Exception {
		LocalDate startDate = LocalDate.parse("2022-01-01");
		int endDate = 13;
		assertEquals(5, GetDaysWithoutHolidays(startDate,endDate));
	}
	@Test
	void contextLoads4() {

		CalculateController calculateController = new CalculateController();
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("averageSalary")).thenReturn("100000");
		when(request.getParameter("startDay")).thenReturn("2022-10-04");
		when(request.getParameter("daysRequest")).thenReturn("14");
		String cash =  calculateController.calculate(request);
		assertEquals("47781,57",cash);
	}
	@Test
	void contextLoads5() {

		CalculateController calculateController = new CalculateController();
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter("averageSalary")).thenReturn("100000");
		when(request.getParameter("startDay")).thenReturn("2022-10-04");
		when(request.getParameter("daysRequest")).thenReturn("0");
		String cash =  calculateController.calculate(request);
		assertEquals("Error: Forbidden vacation days = 0",cash);
	}
}

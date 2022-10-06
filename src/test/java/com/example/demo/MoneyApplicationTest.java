package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class MoneyApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnMessage1() throws Exception {
        this.mockMvc.perform(get("/calculate?averageSalary=100000&startDate=2022-10-04&daysRequest=14")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("47781,57")));
    }
    @Test
    public void shouldReturnMessage2() throws Exception {
        this.mockMvc.perform(get("/calculate?averageSalary=100000&startDate=2022-10-04&daysRequest=0")).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("{\"error\":\"calculate.daysRequest: must be greater than or equal to 1\"}")));
    }
    @Test
    public void shouldReturnMessage3() throws Exception {
        this.mockMvc.perform(get("/calculate?averageSalary=0&startDate=2022-10-04&daysRequest=14")).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("{\"error\":\"calculate.averageSalary: must be greater than or equal to 1\"}")));
    }
}


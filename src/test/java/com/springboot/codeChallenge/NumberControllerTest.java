package com.springboot.codeChallenge;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class NumberControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void isPerfectNumber() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/isPerfectNumber/6")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Your Answer is true")));
    }

    @Test
    public void perfectNumberFromStartNumberToEndNumber() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/from/6/to/1000")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Perfect Number lists : [6, 28, 496]")));
    }
}

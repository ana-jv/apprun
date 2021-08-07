package com.example.apprun;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TrainingControllerIT {

    @Autowired
    private MockMvc mvc;

    @Test
    public void createNewTrainingRecord() throws Exception {
        String trainingJson = "{\"distance\":7.0,\"time\":30,\"dayMonthYear\":\"10-01-21\"}";

        mvc.perform(
                MockMvcRequestBuilders.post("/training")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(trainingJson)
        )
                .andExpect(status().isCreated())
                .andExpect(content().string(trainingJson));

    }
}

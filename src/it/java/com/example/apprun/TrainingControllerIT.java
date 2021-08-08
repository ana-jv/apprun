package com.example.apprun;

import com.example.apprun.domain.model.TrainingRecord;
import com.example.apprun.domain.primary.TrainingUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TrainingControllerIT {

    @Autowired
    private MockMvc mvc;

    @MockBean
    TrainingUseCase runningTrainingUseCase;

    String trainingJson = "{\"distance\":7.0,\"time\":30,\"dayMonthYear\":\"10-01-21\"}";
    TrainingRecord training = new TrainingRecord(7.0, 30, null);

    @Test
    public void createNewTrainingRecord() throws Exception {
        when(runningTrainingUseCase.createTrainingRecord(training)).thenReturn(training);
        mvc.perform(
                MockMvcRequestBuilders.post("/training")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(trainingJson)
        )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.distance", is(7.0)))
                .andExpect(jsonPath("$.time", is(30)))
                .andExpect(jsonPath("$.dayMonthYear", is("10-01-21")));

        verify(runningTrainingUseCase).createTrainingRecord(training);

    }
}

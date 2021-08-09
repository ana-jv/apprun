package com.example.apprun.e2e;

import com.example.apprun.domain.model.TrainingRecord;
import com.example.apprun.domain.repository.TrainingRepository;
import com.example.apprun.infraestructure.entity.RunningTraining;
import com.example.apprun.infraestructure.respository.JpaTrainingRepository;
import com.example.apprun.infraestructure.respository.RunningTrainingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class RunningTrainingE2E {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JpaTrainingRepository repository;

    String trainingJson = "{\"distance\":7.0,\"time\":30,\"dayMonthYear\":\"10-01-21\"}";
    TrainingRecord training = new TrainingRecord(7.0, 30, null);

    @Test
    public void createRunningTrainingRecord() throws Exception {

        mvc.perform(
                MockMvcRequestBuilders.post("/training")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(trainingJson)
        )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.distance", is(7.0)))
                .andExpect(jsonPath("$.time", is(30)))
                .andExpect(jsonPath("$.dayMonthYear", is("10-01-21")));

        List<RunningTraining> records = repository.findAll();
        assertEquals(records.get(0).getDistance(),training.getDistance() );
        assertEquals(records.get(0).getTime(),training.getTime() );

    }




}

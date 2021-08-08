package com.example.apprun.infraestructure;

import com.example.apprun.domain.model.TrainingRecord;
import com.example.apprun.domain.primary.TrainingUseCase;
import com.example.apprun.dto.TrainingRecordDto;
import com.example.apprun.dto.TrainingRecordResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class TrainingController {

    @Autowired
    TrainingUseCase runningTrainingUseCase;

    @PostMapping("/training")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String create(@RequestBody TrainingRecordDto training)  {
        String responseJson = "";
        try {
            TrainingRecord trainingRecord = runningTrainingUseCase.createTrainingRecord(new TrainingRecord(training.getDistance(), training.getTime(), null));
            ObjectMapper mapper = new ObjectMapper();
            TrainingRecordResponseDto response = new TrainingRecordResponseDto(trainingRecord.getDistance(), trainingRecord.getTime(), "10-01-21");
            responseJson = mapper.writeValueAsString(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseJson;
    }

    @GetMapping("/")
    public String getAll() {
        return "App Run";
    }


}

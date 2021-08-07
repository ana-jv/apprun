package com.example.apprun.infraestructure;

import com.example.apprun.dto.TrainingRecordDto;
import com.example.apprun.dto.TrainingRecordResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;

@RestController
public class TrainingController {

    @PostMapping("/training")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String create(@RequestBody TrainingRecordDto training) throws ParseException, JsonProcessingException {
        String responseJson = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            TrainingRecordResponseDto response = new TrainingRecordResponseDto(training.getDistance(), training.getTime(), "10-01-21");
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

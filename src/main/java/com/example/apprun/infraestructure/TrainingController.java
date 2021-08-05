package com.example.apprun.infraestructure;

import com.example.apprun.dto.TrainingRecordDto;
import com.example.apprun.dto.TrainingRecordResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class TrainingController {

    @PostMapping("/training")
    public TrainingRecordResponseDto create(@RequestBody TrainingRecordDto training) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        return new TrainingRecordResponseDto(training.getDistance(), training.getTime(), formatter.parse(formatter.format(today)));
    }


}

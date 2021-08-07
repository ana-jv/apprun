package com.example.apprun.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Date;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TrainingRecordResponseDto {

    private final Double distance;

    private final int time;

    private final String dayMonthYear;


    public TrainingRecordResponseDto(Double distance, int time, String dayMonthYear) {
        this.distance = distance;
        this.time = time;
        this.dayMonthYear = dayMonthYear;
    }
}

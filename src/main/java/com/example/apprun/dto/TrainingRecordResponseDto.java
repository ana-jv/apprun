package com.example.apprun.dto;

import java.util.Date;

public class TrainingRecordResponseDto {

    private final Double distance;

    private final int time;

    private final Date day;


    public TrainingRecordResponseDto(Double distance, int time, Date day) {
        this.distance = distance;
        this.time = time;
        this.day = day;
    }
}

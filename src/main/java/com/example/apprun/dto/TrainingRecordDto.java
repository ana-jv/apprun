package com.example.apprun.dto;

public class TrainingRecordDto {

    private final Double distance;

    private final int time;

    public TrainingRecordDto(Double distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public Double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}

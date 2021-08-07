package com.example.apprun.domain.model;

import java.util.Date;

public class TrainingRecord {
    private final Double distance;

    private final int time;

    private final Date date;

    public TrainingRecord(Double distance, int time, Date date) {
        this.distance = distance;
        this.time = time;
        this.date = date;
    }
}

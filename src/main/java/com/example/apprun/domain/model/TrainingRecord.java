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


    public Double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TrainingRecord))
            return false;
        TrainingRecord other = (TrainingRecord) o;
        boolean distanceEquals = (this.distance == null && other.distance == null)
                || (this.distance != null && this.distance.equals(other.distance));
        boolean timeEquals = this.time == other.time;
        return timeEquals && distanceEquals;
    }
}

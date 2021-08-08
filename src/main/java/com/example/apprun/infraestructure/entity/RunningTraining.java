package com.example.apprun.infraestructure.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class RunningTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double distance;
    private int time;
    private Date date;


    public RunningTraining(Double distance, int time, Date date) {
        this.distance = distance;
        this.time = time;
        this.date = date;
    }

    public RunningTraining() {

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
}

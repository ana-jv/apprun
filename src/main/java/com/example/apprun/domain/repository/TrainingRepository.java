package com.example.apprun.domain.repository;

import com.example.apprun.domain.model.TrainingRecord;

import java.util.List;

public interface TrainingRepository {

    TrainingRecord save(TrainingRecord training);
    List<TrainingRecord> findAll();
}

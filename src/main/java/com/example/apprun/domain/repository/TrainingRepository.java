package com.example.apprun.domain.repository;

import com.example.apprun.domain.model.TrainingRecord;

public interface TrainingRepository {

    TrainingRecord save(TrainingRecord training);
}

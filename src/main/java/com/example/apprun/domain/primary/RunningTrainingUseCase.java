package com.example.apprun.domain.primary;

import com.example.apprun.domain.model.TrainingRecord;
import com.example.apprun.domain.repository.TrainingRepository;

public class RunningTrainingUseCase implements TrainingUseCase {

    private TrainingRepository repository;

    public RunningTrainingUseCase(TrainingRepository repository) {
        this.repository = repository;
    }


    @Override
    public TrainingRecord createTrainingRecord(TrainingRecord training) {
        return repository.save(training);
    }
}

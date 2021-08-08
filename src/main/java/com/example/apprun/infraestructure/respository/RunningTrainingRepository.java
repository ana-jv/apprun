package com.example.apprun.infraestructure.respository;

import com.example.apprun.domain.model.TrainingRecord;
import com.example.apprun.domain.repository.TrainingRepository;
import com.example.apprun.infraestructure.entity.RunningTraining;

import java.util.List;
import java.util.stream.Collectors;

public class RunningTrainingRepository implements TrainingRepository {

    private final JpaTrainingRepository repository;

    public RunningTrainingRepository(JpaTrainingRepository repository) {
        this.repository = repository;
    }

    @Override
    public TrainingRecord save(TrainingRecord training) {
        RunningTraining entity = repository.save(new RunningTraining(training.getDistance(), training.getTime(), null));
        return new TrainingRecord(entity.getDistance(), entity.getTime(), entity.getDate());
    }

    @Override
    public List<TrainingRecord> findAll() {
        return repository.findAll()
                .stream()
                .map(e -> new TrainingRecord(e.getDistance(), e.getTime(), e.getDate()))
                .collect(Collectors.toList());
    }


}

package com.example.apprun.domain;

import com.example.apprun.domain.model.TrainingRecord;
import com.example.apprun.domain.primary.RunningTrainingUseCase;
import com.example.apprun.domain.repository.TrainingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RunningTrainingUseCaseTest {

    @Mock
    TrainingRepository repository;

    RunningTrainingUseCase runningTraining = new RunningTrainingUseCase(repository);

    @Test
    public void emptyTraining(){
        when(repository.save(null)).thenReturn(null);
        assertEquals(runningTraining.createTrainingRecord(null), null);
    }

    @Test
    public void createOneTrainingRecord(){

        TrainingRecord record = new TrainingRecord(7.0, 30, null);
        when(repository.save(record)).thenReturn(record);
        TrainingRecord recordCreated = runningTraining.createTrainingRecord(record);

        verify(repository).save(record);

        assertEquals(recordCreated, record);
    }

}

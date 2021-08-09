package com.example.apprun.domain;

import com.example.apprun.domain.model.TrainingRecord;
import com.example.apprun.domain.primary.RunningTrainingUseCase;
import com.example.apprun.domain.repository.TrainingRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RunningTrainingUseCaseTest {

    TrainingRepository repository = Mockito.mock(TrainingRepository.class) ;

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

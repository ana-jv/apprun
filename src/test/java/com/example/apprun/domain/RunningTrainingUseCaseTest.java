package com.example.apprun.domain;

import com.example.apprun.domain.primary.RunningTrainingUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RunningTrainingUseCaseTest {

    RunningTrainingUseCase runningTraining = new RunningTrainingUseCase();

    @Test
    public void emptyTraining(){
        assertEquals(runningTraining.createTrainingRecord(null), null);
    }

}

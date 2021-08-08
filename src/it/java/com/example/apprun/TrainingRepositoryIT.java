package com.example.apprun;

import com.example.apprun.domain.model.TrainingRecord;
import com.example.apprun.domain.repository.TrainingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TrainingRepositoryIT {

    @Autowired
    private TrainingRepository trainingRepository;

    @Test
    public void saveTrainingRecord(){
        trainingRepository.save(new TrainingRecord(7.0, 30, null));
        List<TrainingRecord> trainingRecordList = trainingRepository.findAll();

        assertNotNull(trainingRecordList);
        assertEquals(trainingRecordList.get(0).getDistance(), 7.0);
    }
}

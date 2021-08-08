package com.example.apprun.infraestructure;

import com.example.apprun.domain.primary.RunningTrainingUseCase;
import com.example.apprun.domain.primary.TrainingUseCase;
import com.example.apprun.domain.repository.TrainingRepository;
import com.example.apprun.infraestructure.respository.JpaTrainingRepository;
import com.example.apprun.infraestructure.respository.RunningTrainingRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public TrainingUseCase trainingUseCase() {
        return new RunningTrainingUseCase();
    }

    @Bean
    public TrainingRepository trainingRepository(JpaTrainingRepository repository) {
        return new RunningTrainingRepository(repository);
    }

}

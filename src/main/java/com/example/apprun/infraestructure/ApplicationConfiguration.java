package com.example.apprun.infraestructure;

import com.example.apprun.domain.primary.RunningTrainingUseCase;
import com.example.apprun.domain.primary.TrainingUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public TrainingUseCase trainingUseCase() {return  new RunningTrainingUseCase();}
}

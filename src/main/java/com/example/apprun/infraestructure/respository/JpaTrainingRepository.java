package com.example.apprun.infraestructure.respository;

import com.example.apprun.infraestructure.entity.RunningTraining;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTrainingRepository extends JpaRepository<RunningTraining, Long> {
}

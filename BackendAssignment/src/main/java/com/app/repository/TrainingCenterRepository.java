package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.model.TrainingCenter;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
    @Query("SELECT distinct tc FROM TrainingCenter tc LEFT JOIN FETCH tc.coursesOffered")
    List<TrainingCenter> findAllWithCourses();

}


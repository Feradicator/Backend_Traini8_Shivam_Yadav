package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.model.TrainingCenter;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
    @Query("SELECT distinct tc FROM TrainingCenter tc LEFT JOIN FETCH tc.coursesOffered")//getting data in more controlled way,using jpql left join
    List<TrainingCenter> findAllWithCourses();

    //   @Query("SELECT tc FROM TrainingCenter tc " +
    //        "WHERE (:centerName IS NULL OR tc.centerName LIKE CONCAT('%', :centerName, '%')) " +
    //        "AND (:city IS NULL OR tc.address.city = :city) " +
    //        "AND (:state IS NULL OR tc.address.state = :state) " +
    //        "AND (:studentCapacity IS NULL OR tc.studentCapacity >= :studentCapacity)")
    // List<TrainingCenter> findFilteredTrainingCenters(
    //         @Param("centerName") String centerName,
    //         @Param("city") String city,
    //         @Param("state") String state,
    //         @Param("studentCapacity") Integer studentCapacity);

}


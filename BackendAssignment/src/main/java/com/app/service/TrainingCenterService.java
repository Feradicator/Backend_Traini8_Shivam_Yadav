package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import com.app.dto.TrainingCenterDto;
import com.app.model.TrainingCenter;
import com.app.repository.TrainingCenterRepository;

import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import java.util.stream.Collectors;

@Service
public class TrainingCenterService {

    @Autowired
    private TrainingCenterRepository repository;

    public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
        trainingCenter.setCreatedOn(Instant.now().getEpochSecond());
        return repository.save(trainingCenter);
    }

    public List<TrainingCenter> getAllTrainingCenters() {
        return repository.findAllWithCourses();
    }

    public List<TrainingCenterDto> getAllTrainingCentersLazy() {
        List<TrainingCenter> centers = repository.findAll();
        return centers.stream().map(center -> new TrainingCenterDto(
                center.getId(),
                center.getCenterName(),
                center.getCenterCode(),

                center.getStudentCapacity(),

                center.getContactEmail(),
                center.getContactPhone())).collect(Collectors.toList());
    }

    // public List<TrainingCenter> getFilteredTrainingCenters(Optional<String> centerName,
    //         Optional<String> city,
    //         Optional<String> state,
    //         Optional<Integer> studentCapacity) {
    //     return repository.findFilteredTrainingCenters(
    //             centerName.orElse(null),
    //             city.orElse(null),
    //             state.orElse(null),
    //             studentCapacity.orElse(null));
    // }
}

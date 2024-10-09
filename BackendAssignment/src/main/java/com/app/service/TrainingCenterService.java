package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import com.app.model.TrainingCenter;
import com.app.repository.TrainingCenterRepository;

import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
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

    // public List<TrainingCenter> getFilteredTrainingCenters(Optional<String> centerName, Optional<String> city,
    //         Optional<String> state, Optional<Integer> studentCapacity) {
    //     Specification<TrainingCenter> spec = Specification.where(null);

    //     if (centerName.isPresent()) {
    //         spec = spec.and((root, query, cb) -> cb.like(root.get("centerName"), "%" + centerName.get() + "%"));
    //     }

    //     if (city.isPresent()) {
    //         spec = spec.and((root, query, cb) -> cb.equal(root.get("address").get("city"), city.get()));
    //     }

    //     if (state.isPresent()) {
    //         spec = spec.and((root, query, cb) -> cb.equal(root.get("address").get("state"), state.get()));
    //     }

    //     if (studentCapacity.isPresent()) {
    //         spec = spec.and(
    //                 (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("studentCapacity"), studentCapacity.get()));
    //     }

       

    //     return repository.findAll(spec);
    // }
}

package com.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import com.app.dto.TrainingCenterDto;
import com.app.model.TrainingCenter;
import com.app.service.TrainingCenterService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/training-centers")
public class TrainingCenterController {

    private final TrainingCenterService service;

    public TrainingCenterController(TrainingCenterService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        TrainingCenter savedCenter = service.createTrainingCenter(trainingCenter);
        return ResponseEntity.ok(savedCenter);
    }

    @GetMapping
    
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> centers = service.getAllTrainingCenters();
        return ResponseEntity.ok(centers);
    }
    // @GetMapping("/filters")
    // public ResponseEntity<List<TrainingCenter>> getFilteredTrainingCenters(
    //         @RequestParam Optional<String> centerName,
    //         @RequestParam Optional<String> city,
    //         @RequestParam Optional<String> state,
    //         @RequestParam Optional<Integer> studentCapacity) {
        
    //     List<TrainingCenter> trainingCenters = service.getFilteredTrainingCenters(centerName, city, state, studentCapacity);
        
    //     return ResponseEntity.ok(trainingCenters);
    // }
}


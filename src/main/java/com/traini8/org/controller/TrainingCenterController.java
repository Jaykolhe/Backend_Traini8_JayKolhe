package com.traini8.org.controller;


import com.traini8.org.entity.TrainingCenter;
import com.traini8.org.mapper.TrainingCentermapper;
import com.traini8.org.model.Response.TrainingCenterResponseDto;
import com.traini8.org.model.TrainingCenterRequestDto;
import com.traini8.org.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    private final TrainingCenterService trainingCenterService;
    private final TrainingCentermapper trainingCentermapper;

    public TrainingCenterController(TrainingCenterService trainingCenterService, TrainingCentermapper trainingCentermapper) {
        this.trainingCenterService = trainingCenterService;
        this.trainingCentermapper = trainingCentermapper;
    }

    //post api to register new training center
    @PostMapping("/register")
    public ResponseEntity<TrainingCenterResponseDto> createTrainingCenter(
            @Valid @RequestBody TrainingCenterRequestDto requestDTO) {
        TrainingCenterResponseDto savedCenter = trainingCenterService.saveTrainingCenter(requestDTO);
       // TrainingCenterResponseDto responseDto = trainingCentermapper.mapToDto(savedCenter);
        return ResponseEntity.ok(savedCenter);
    }


    //get Api to fetch all training centers
    @GetMapping("/getAllTrainingCenters")
    public ResponseEntity<List<TrainingCenterResponseDto>> getAllTrainingCenters() {
        List<TrainingCenterResponseDto> trainingCenters = trainingCenterService.getAllTrainingCenters();
        return ResponseEntity.ok(trainingCenters); // Returns an empty list if no data exists
    }
}

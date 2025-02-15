package com.traini8.org.service;

import com.traini8.org.entity.TrainingCenter;
import com.traini8.org.model.Response.TrainingCenterResponseDto;
import com.traini8.org.model.TrainingCenterRequestDto;

import java.util.List;

public interface TrainingCenterService {

    public TrainingCenterResponseDto saveTrainingCenter(TrainingCenterRequestDto trainingCenterRequestDto);

    List<TrainingCenterResponseDto> getAllTrainingCenters();

}

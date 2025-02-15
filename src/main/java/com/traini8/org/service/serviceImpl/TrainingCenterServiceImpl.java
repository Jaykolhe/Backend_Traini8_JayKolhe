package com.traini8.org.service.serviceImpl;

import com.traini8.org.entity.Address;
import com.traini8.org.entity.ContactInfo;
import com.traini8.org.entity.Course;
import com.traini8.org.entity.TrainingCenter;
import com.traini8.org.mapper.TrainingCentermapper;
import com.traini8.org.model.Response.TrainingCenterResponseDto;
import com.traini8.org.model.TrainingCenterRequestDto;
import com.traini8.org.repository.TrainingCenterRepository;
import com.traini8.org.service.AddressService;
import com.traini8.org.service.ContactInfoService;
import com.traini8.org.service.CourseService;
import com.traini8.org.service.TrainingCenterService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TrainingCenterServiceImpl implements TrainingCenterService {

    private final TrainingCenterRepository trainingCenterRepository;
    private final AddressService addressService;
    private final ContactInfoService contactInfoService;
    private final CourseService courseService;
    private final TrainingCentermapper trainingCentermapper;

    public TrainingCenterServiceImpl(TrainingCenterRepository trainingCenterRepository, AddressService addressService, ContactInfoService contactInfoService, CourseService courseService, TrainingCentermapper trainingCentermapper) {
        this.trainingCenterRepository = trainingCenterRepository;
        this.addressService = addressService;
        this.contactInfoService = contactInfoService;
        this.courseService = courseService;
        this.trainingCentermapper = trainingCentermapper;
    }


    @Transactional
    @Override
    public TrainingCenterResponseDto saveTrainingCenter(TrainingCenterRequestDto trainingCenterRequestDto) {

        // Map DTO to Entity (Convert request data into TrainingCenter entity)
        TrainingCenter trainingCenter = trainingCentermapper.mapDtoToEntity(trainingCenterRequestDto);

        // Save TrainingCenter entity first to generate an ID (since other entities depend on it)
        trainingCenter = trainingCenterRepository.save(trainingCenter);

        Address address = trainingCentermapper.mapDtoToAddress(trainingCenterRequestDto, trainingCenter);
        address = addressService.saveAddress(address);
        trainingCenter.setAddress(address);

        ContactInfo contactInfo = trainingCentermapper.mapDtoToContactInfo(trainingCenterRequestDto, trainingCenter);
        contactInfo = contactInfoService.saveContactInfo(contactInfo);
        trainingCenter.setContactInfo(contactInfo);

        Set<Course> courses = courseService.getOrCreateCourses(trainingCenterRequestDto.getCourses());
        trainingCenter.setCourses(courses);
        trainingCenter = trainingCenterRepository.save(trainingCenter);

        // Convert TrainingCenter entity to DTO before returning the response
        return trainingCentermapper.mapToDto(trainingCenter);
    }

    @Override
    public List<TrainingCenterResponseDto> getAllTrainingCenters() {
        List<TrainingCenter> trainingCenters = trainingCenterRepository.findAll();

        // Convert List of Entities to List of DTOs
        return trainingCenters.stream()
                .map(trainingCentermapper::mapToDto)
                .collect(Collectors.toList());
    }


}

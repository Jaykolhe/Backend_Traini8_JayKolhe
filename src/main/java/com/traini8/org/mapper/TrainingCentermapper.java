package com.traini8.org.mapper;

import com.traini8.org.entity.Address;
import com.traini8.org.entity.ContactInfo;
import com.traini8.org.entity.Course;
import com.traini8.org.entity.TrainingCenter;
import com.traini8.org.model.AddressDto;
import com.traini8.org.model.ContactInfoDto;
import com.traini8.org.model.Response.TrainingCenterResponseDto;
import com.traini8.org.model.TrainingCenterRequestDto;
import com.traini8.org.repository.CourseRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class TrainingCentermapper {

    private final CourseRepository courseRepository;

    public TrainingCentermapper(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public TrainingCenter mapDtoToEntity(TrainingCenterRequestDto dto) {
        TrainingCenter trainingCenter = new TrainingCenter();
        trainingCenter.setCenterName(dto.getCenterName());
        trainingCenter.setCenterCode(dto.getCenterCode());
        trainingCenter.setStudentCapacity(dto.getStudentCapacity());

        trainingCenter.setCourses(mapDtoToCourses(dto));

        return trainingCenter;
    }

public TrainingCenterResponseDto mapToDto(TrainingCenter trainingCenter) {
    TrainingCenterResponseDto dto = new TrainingCenterResponseDto(trainingCenter);
    dto.setId(trainingCenter.getId());
    dto.setCenterName(trainingCenter.getCenterName());
    dto.setCenterCode(trainingCenter.getCenterCode());
    dto.setStudentCapacity(trainingCenter.getStudentCapacity());
    dto.setCreatedOn(Long.valueOf(trainingCenter.getCreatedOn().toString()));


    dto.setAddress(new AddressDto(trainingCenter.getAddress()));
    dto.setContactInfo(new ContactInfoDto(trainingCenter.getContactInfo()));

    Set<String> courseNames = trainingCenter.getCourses().stream()
            .map(course -> course.getCourseName())
            .collect(Collectors.toSet());
    dto.setCourses(courseNames);

    return new TrainingCenterResponseDto(trainingCenter);
}

    public Address mapDtoToAddress(TrainingCenterRequestDto dto, TrainingCenter trainingCenter) {
        Address address = new Address();
        address.setTrainingCenter(trainingCenter);
        address.setDetailedAddress(dto.getDetailedAddress());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setPincode(dto.getPincode());
        return address;
    }

    public ContactInfo mapDtoToContactInfo(TrainingCenterRequestDto dto, TrainingCenter trainingCenter) {
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setTrainingCenter(trainingCenter);
        contactInfo.setContactEmail(dto.getContactEmail());
        contactInfo.setContactPhone(dto.getContactPhone());
        return contactInfo;
    }

    private Set<Course> mapDtoToCourses(TrainingCenterRequestDto dto) {
        Set<Course> courses = new HashSet<>();
        for (String courseName : dto.getCourses()) {
            Course course = courseRepository.findByCourseName(courseName)
                    .orElseGet(() -> {
                        Course newCourse = new Course();
                        newCourse.setCourseName(courseName);
                        return courseRepository.save(newCourse);
                    });
            courses.add(course);
        }
        return courses;
    }



}

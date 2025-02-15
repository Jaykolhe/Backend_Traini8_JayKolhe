package com.traini8.org.model.Response;

import com.traini8.org.entity.Address;
import com.traini8.org.entity.ContactInfo;
import com.traini8.org.entity.Course;
import com.traini8.org.entity.TrainingCenter;
import com.traini8.org.model.AddressDto;
import com.traini8.org.model.ContactInfoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingCenterResponseDto {
    private Long id;
    private String centerName;
    private String centerCode;
    private Integer studentCapacity;
    private Long createdOn;
    private AddressDto address;
    private ContactInfoDto contactInfo;
    private Set<String> courses;

    public TrainingCenterResponseDto(TrainingCenter trainingCenter) {
        this.id = trainingCenter.getId();
        this.centerName = trainingCenter.getCenterName();
        this.centerCode = trainingCenter.getCenterCode();
        this.studentCapacity = trainingCenter.getStudentCapacity();
        this.createdOn = (trainingCenter.getCreatedOn() != null) ? trainingCenter.getCreatedOn() * 1000 : null;
        this.address = (trainingCenter.getAddress() != null) ? new AddressDto(trainingCenter.getAddress()) : null;
        this.contactInfo = (trainingCenter.getContactInfo() != null) ? new ContactInfoDto(trainingCenter.getContactInfo()) : null;
        this.courses = trainingCenter.getCourses() != null ? trainingCenter.getCourses().stream().map(Course::getCourseName).collect(Collectors.toSet()) : null;
    }


}
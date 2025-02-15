package com.traini8.org.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name", nullable = false, unique = true, length = 255)
    @NotBlank(message = "Course name is required")
    @Size(max = 255, message = "Course name must be less than 255 characters")
    private String courseName;

    @ManyToMany(mappedBy = "courses")
    private Set<TrainingCenter> trainingCenters;
}

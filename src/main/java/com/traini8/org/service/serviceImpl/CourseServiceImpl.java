package com.traini8.org.service.serviceImpl;

import com.traini8.org.entity.Course;
import com.traini8.org.repository.CourseRepository;
import com.traini8.org.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Set<Course> getOrCreateCourses(Set<String> courseNames) {
        Set<Course> courses = new HashSet<>();
        for (String courseName : courseNames) {
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

package com.traini8.org.service;

import com.traini8.org.entity.Course;

import java.util.Set;

public interface CourseService {

    public Set<Course> getOrCreateCourses(Set<String> courseNames);
}

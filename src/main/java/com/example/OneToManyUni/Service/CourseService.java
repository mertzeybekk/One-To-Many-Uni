package com.example.OneToManyUni.Service;

import com.example.OneToManyUni.Entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    public Course Add(Course course);
    public void deleteById(Long id);
    List<Course>getAll();
    public Optional<Course> getById(Long id);
    public void updateCourse(Course course,Long id);
}

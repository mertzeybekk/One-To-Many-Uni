package com.example.OneToManyUni.Repository;

import com.example.OneToManyUni.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository  extends JpaRepository<Course,Long> {
}

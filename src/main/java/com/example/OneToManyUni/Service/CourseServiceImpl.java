package com.example.OneToManyUni.Service;

import com.example.OneToManyUni.Entity.Course;
import com.example.OneToManyUni.Entity.Review;
import com.example.OneToManyUni.Repository.CourseRepository;
import com.example.OneToManyUni.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public Course Add(Course course) {
        courseRepository.save(course);
        return course;
    }

    @Override
    public void deleteById(Long id) {
        if(id==null) {
            throw new RuntimeException();
        }

          courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getAll() {
        List<Course>courseList=courseRepository.findAll();
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public void updateCourse(Course course, Long id) {
        Optional<Course> courseUpdate= Optional.of(courseRepository.findById(id).get());
        Optional<Review> getComment=reviewRepository.findById(id);
        getComment.get().setComment(course.getReviewSet().toString());
        if(courseUpdate.isPresent()){
            courseUpdate.get().setTitle(course.getTitle());
           // courseUpdate.get().setReviewSet(getComment.get().getComment());
            courseRepository.saveAll(List.of(courseUpdate.get()));
        }


    }
}

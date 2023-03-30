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
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public void Add(Review review,Long id) {
        Optional<Course> course=courseRepository.findById(id);
       course.get().getReviewSet().add(review);
       reviewRepository.save(review);
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            throw new RuntimeException();
        }
        reviewRepository.deleteById(id);

    }

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> getById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public void update(Review review, Long id) {
            Optional<Review>reviewOptional= reviewRepository.findById(id);
            if(reviewOptional.isPresent()){
                reviewOptional.get().setComment(review.getComment());
                reviewRepository.save(reviewOptional.get());
            }
    }
}

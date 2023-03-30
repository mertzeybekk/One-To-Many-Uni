package com.example.OneToManyUni.Controller;

import com.example.OneToManyUni.Entity.Review;
import com.example.OneToManyUni.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping("/add/{reviewId}")
    public void Add(@RequestBody Review review,@PathVariable Long reviewId){
        reviewService.Add(review,reviewId);
    }

    @GetMapping("/getAll")
    public List<Review> getAll(){
        return reviewService.getAll();
    }
    @GetMapping("/getById/{reviewId}")
    public Optional<Review> getByIdReview(@PathVariable Long reviewId){
        return reviewService.getById(reviewId);
    }
    @DeleteMapping("/deleteById/{reviewId}")
    public  void deleteById(@PathVariable Long reviewId){
        reviewService.getById(reviewId);
    }

}

package com.example.OneToManyUni.Service;

import com.example.OneToManyUni.Entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    public void Add(Review review,Long id);
    public void delete(Long id);
    public List<Review> getAll();
    public Optional<Review> getById(Long id);
    public void update(Review review,Long id);
}

package com.example.OneToManyUni.Repository;

import com.example.OneToManyUni.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}

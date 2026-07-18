package com.explore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.explore.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // Get all reviews of a Tourist Place
    List<Review> findByTouristPlaceId(Long touristPlaceId);

    // Get all reviews given by a User
    List<Review> findByUserId(Long userId);

}
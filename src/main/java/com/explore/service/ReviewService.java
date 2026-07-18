package com.explore.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.explore.dto.ReviewRequest;
import com.explore.dto.ReviewResponse;
import com.explore.entity.Review;
import com.explore.entity.TouristPlace;
import com.explore.entity.User;
import com.explore.repository.ReviewRepository;
import com.explore.repository.TouristPlaceRepository;
import com.explore.repository.UserRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TouristPlaceRepository touristPlaceRepository;

    // ==========================
    // Add Review
    // ==========================
    public String addReview(ReviewRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        TouristPlace place = touristPlaceRepository.findById(request.getTouristPlaceId())
                .orElseThrow(() -> new RuntimeException("Tourist Place Not Found"));

        Review review = new Review();

        review.setUser(user);
        review.setTouristPlace(place);
        review.setRating(request.getRating());
        review.setComment(request.getComment());
        review.setCreatedAt(LocalDateTime.now());

        reviewRepository.save(review);

        return "Review Added Successfully";
    }

    // ==========================
    // Get Reviews By Tourist Place
    // ==========================
    public List<ReviewResponse> getReviewsByTouristPlace(Long placeId) {

        List<Review> reviews = reviewRepository.findByTouristPlaceId(placeId);

        return reviews.stream().map(review -> {

            ReviewResponse response = new ReviewResponse();

            response.setId(review.getId());
            response.setUserName(review.getUser().getFullName());
            response.setRating(review.getRating());
            response.setComment(review.getComment());
            response.setCreatedAt(review.getCreatedAt());

            return response;

        }).collect(Collectors.toList());

    }

    // ==========================
    // Delete Review
    // ==========================
    public String deleteReview(Long id) {

        if (!reviewRepository.existsById(id)) {
            return "Review Not Found";
        }

        reviewRepository.deleteById(id);

        return "Review Deleted Successfully";
    }

}
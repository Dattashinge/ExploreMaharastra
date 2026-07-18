package com.explore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.explore.dto.ReviewRequest;
import com.explore.dto.ReviewResponse;
import com.explore.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // ==========================
    // Add Review
    // ==========================
    @PostMapping
    public String addReview(@RequestBody ReviewRequest request) {

        return reviewService.addReview(request);

    }

    // ==========================
    // Get Reviews By Tourist Place
    // ==========================
    @GetMapping("/place/{placeId}")
    public List<ReviewResponse> getReviewsByTouristPlace(
            @PathVariable Long placeId) {

        return reviewService.getReviewsByTouristPlace(placeId);

    }

    // ==========================
    // Delete Review
    // ==========================
    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {

        return reviewService.deleteReview(id);

    }

}
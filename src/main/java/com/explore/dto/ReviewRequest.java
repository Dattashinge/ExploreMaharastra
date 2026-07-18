package com.explore.dto;

public class ReviewRequest {

    private Long userId;

    private Long touristPlaceId;

    private Integer rating;

    private String comment;

    public ReviewRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTouristPlaceId() {
        return touristPlaceId;
    }

    public void setTouristPlaceId(Long touristPlaceId) {
        this.touristPlaceId = touristPlaceId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
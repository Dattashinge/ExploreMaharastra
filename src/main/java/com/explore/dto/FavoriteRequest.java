package com.explore.dto;

public class FavoriteRequest {

    private Long userId;

    private Long touristPlaceId;

    public FavoriteRequest() {
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

}
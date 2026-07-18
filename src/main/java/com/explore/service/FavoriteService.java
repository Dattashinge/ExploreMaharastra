package com.explore.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.explore.dto.FavoriteRequest;
import com.explore.dto.FavoriteResponse;
import com.explore.entity.Favorite;
import com.explore.entity.TouristPlace;
import com.explore.entity.User;
import com.explore.repository.FavoriteRepository;
import com.explore.repository.TouristPlaceRepository;
import com.explore.repository.UserRepository;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TouristPlaceRepository touristPlaceRepository;

    // Add Favorite
    public String addFavorite(FavoriteRequest request) {

        if (favoriteRepository.findByUserIdAndTouristPlaceId(
                request.getUserId(),
                request.getTouristPlaceId()).isPresent()) {

            return "Already Added To Favorites";
        }

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        TouristPlace place = touristPlaceRepository
                .findById(request.getTouristPlaceId())
                .orElseThrow(() -> new RuntimeException("Tourist Place Not Found"));

        Favorite favorite = new Favorite();

        favorite.setUser(user);
        favorite.setTouristPlace(place);
        favorite.setCreatedAt(LocalDateTime.now());

        favoriteRepository.save(favorite);

        return "Added To Favorites Successfully";
    }

    // Get User Favorites
    public List<FavoriteResponse> getUserFavorites(Long userId) {

        List<Favorite> favorites = favoriteRepository.findByUserId(userId);

        List<FavoriteResponse> responseList = new ArrayList<>();

        for (Favorite favorite : favorites) {

            FavoriteResponse response = new FavoriteResponse();

            response.setFavoriteId(favorite.getId());
            response.setPlaceId(favorite.getTouristPlace().getId());
            response.setPlaceName(favorite.getTouristPlace().getName());
            response.setImageUrl(favorite.getTouristPlace().getImageUrl());

            responseList.add(response);
        }

        return responseList;
    }

    // Remove Favorite
    public String removeFavorite(Long id) {

        if (!favoriteRepository.existsById(id)) {
            return "Favorite Not Found";
        }

        favoriteRepository.deleteById(id);

        return "Favorite Removed Successfully";
    }

}
package com.explore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.explore.dto.FavoriteRequest;
import com.explore.dto.FavoriteResponse;
import com.explore.service.FavoriteService;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin(origins = "*")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    // Add Favorite
    @PostMapping
    public String addFavorite(@RequestBody FavoriteRequest request) {

        return favoriteService.addFavorite(request);

    }

    // Get User Favorites
    @GetMapping("/user/{userId}")
    public List<FavoriteResponse> getUserFavorites(
            @PathVariable Long userId) {

        return favoriteService.getUserFavorites(userId);

    }

    // Remove Favorite
    @DeleteMapping("/{id}")
    public String removeFavorite(@PathVariable Long id) {

        return favoriteService.removeFavorite(id);

    }

}
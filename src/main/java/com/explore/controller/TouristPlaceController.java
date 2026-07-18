package com.explore.controller;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.explore.dto.TouristPlaceRequest;
import com.explore.entity.TouristPlace;
import com.explore.service.TouristPlaceService;

@RestController
@RequestMapping("/api/tourist-places")
@CrossOrigin(origins = "*")
public class TouristPlaceController {

    @Autowired
    private TouristPlaceService touristPlaceService;

    // ==========================
    // Add Tourist Place
    // ==========================

    @PostMapping
    public ResponseEntity<String> addTouristPlace(
            @RequestBody TouristPlaceRequest request) {

        String message = touristPlaceService.addTouristPlace(request);

        if (message.equals("Tourist Place Added Successfully")) {
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    // ==========================
    // Get All Tourist Places
    // ==========================

    @GetMapping
    public List<TouristPlace> getAllTouristPlaces() {

        return touristPlaceService.getAllTouristPlaces();

    }

    // ==========================
    // Get Tourist Place By Id
    // ==========================

    @GetMapping("/{id}")
    public ResponseEntity<TouristPlace> getTouristPlaceById(
            @PathVariable Long id) {

        TouristPlace place =
                touristPlaceService.getTouristPlaceById(id);

        if (place == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(place);

    }

    // ==========================
    // Get Places By District
    // ==========================

    @GetMapping("/district/{districtId}")
    public List<TouristPlace> getPlacesByDistrict(
            @PathVariable Long districtId) {

        return touristPlaceService.getPlacesByDistrict(districtId);

    }

    // ==========================
    // Search Tourist Places
    // ==========================

    @GetMapping("/search")
    public List<TouristPlace> searchPlaces(
            @RequestParam String keyword) {

        return touristPlaceService.searchPlaces(keyword);

    }

    // ==========================
    // Update Tourist Place
    // ==========================

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTouristPlace(
            @PathVariable Long id,
            @RequestBody TouristPlaceRequest request) {

        String message =
                touristPlaceService.updateTouristPlace(id, request);

        if (message.equals("Tourist Place Updated Successfully")) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        }

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);

    }

    // ==========================
    // Delete Tourist Place
    // ==========================

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTouristPlace(
            @PathVariable Long id) {

        String message =
                touristPlaceService.deleteTouristPlace(id);

        if (message.equals("Tourist Place Deleted Successfully")) {
            return new ResponseEntity<>(message, HttpStatus.OK);
        }

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);

    }
    
    @GetMapping("/page")
    public Page<TouristPlace> getTouristPlaces(

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "5") int size,

            @RequestParam(defaultValue = "id") String sortBy,

            @RequestParam(defaultValue = "asc") String direction) {

        return touristPlaceService.getTouristPlaces(
                page,
                size,
                sortBy,
                direction);

    }
    

}
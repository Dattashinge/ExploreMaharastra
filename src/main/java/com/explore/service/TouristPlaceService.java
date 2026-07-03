package com.explore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.explore.dto.TouristPlaceRequest;
import com.explore.entity.District;
import com.explore.entity.TouristPlace;
import com.explore.repository.DistrictRepository;
import com.explore.repository.TouristPlaceRepository;

@Service
public class TouristPlaceService {

	@Autowired
	private TouristPlaceRepository touristPlaceRepository;

	@Autowired
	private DistrictRepository districtRepository;

	// ============================
	// Add Tourist Place
	// ============================

	public String addTouristPlace(TouristPlaceRequest request) {

		Optional<District> optionalDistrict =
				districtRepository.findById(request.getDistrictId());

		if (optionalDistrict.isEmpty()) {
			return "District Not Found";
		}

		TouristPlace place = new TouristPlace();

		place.setName(request.getName());
		place.setDescription(request.getDescription());
		place.setHistory(request.getHistory());
		place.setBestTimeToVisit(request.getBestTimeToVisit());
		place.setEntryFee(request.getEntryFee());
		place.setOpeningTime(request.getOpeningTime());
		place.setClosingTime(request.getClosingTime());
		place.setRating(request.getRating());
		place.setImageUrl(request.getImageUrl());
		place.setDistrict(optionalDistrict.get());
		place.setLocation(request.getLocation());

		place.setAddress(request.getAddress());

		place.setGoogleMapUrl(request.getGoogleMapUrl());

		place.setCategory(request.getCategory());

		place.setFamousFor(request.getFamousFor());

		place.setNearestRailway(request.getNearestRailway());

		place.setNearestAirport(request.getNearestAirport());
		place.setContactNumber(request.getContactNumber());
		place.setWebsite(request.getWebsite());

		place.setFeatured(request.isFeatured());

		touristPlaceRepository.save(place);

		return "Tourist Place Added Successfully";
	}

	// ============================
	// Get All Tourist Places
	// ============================

	public List<TouristPlace> getAllTouristPlaces() {

		return touristPlaceRepository.findAll();

	}

	// ============================
	// Get Places By District
	// ============================

	public List<TouristPlace> getPlacesByDistrict(Long districtId) {

		Optional<District> optionalDistrict =
				districtRepository.findById(districtId);

		if (optionalDistrict.isEmpty()) {
			return List.of();
		}

		return touristPlaceRepository.findByDistrict(optionalDistrict.get());

	}

	// ============================
	// Search Tourist Place
	// ============================

	public List<TouristPlace> searchPlace(String name) {

		return touristPlaceRepository.findByNameContainingIgnoreCase(name);

	}
	
	// ============================
	// Update Tourist Place
	// ============================

	public String updateTouristPlace(Long id, TouristPlaceRequest request) {

		Optional<TouristPlace> optionalPlace = touristPlaceRepository.findById(id);

		if (optionalPlace.isEmpty()) {
			return "Tourist Place Not Found";
		}

		Optional<District> optionalDistrict = districtRepository.findById(request.getDistrictId());

		if (optionalDistrict.isEmpty()) {
			return "District Not Found";
		}

		TouristPlace place = optionalPlace.get();

		place.setName(request.getName());
		place.setDescription(request.getDescription());
		place.setHistory(request.getHistory());
		place.setBestTimeToVisit(request.getBestTimeToVisit());
		place.setEntryFee(request.getEntryFee());
		place.setOpeningTime(request.getOpeningTime());
		place.setClosingTime(request.getClosingTime());
		place.setRating(request.getRating());
		place.setImageUrl(request.getImageUrl());
		place.setDistrict(optionalDistrict.get());
		place.setLocation(request.getLocation());

		place.setAddress(request.getAddress());

		place.setGoogleMapUrl(request.getGoogleMapUrl());

		place.setCategory(request.getCategory());

		place.setFamousFor(request.getFamousFor());

		place.setNearestRailway(request.getNearestRailway());

		place.setNearestAirport(request.getNearestAirport());
		
		place.setContactNumber(request.getContactNumber());
		place.setWebsite(request.getWebsite());

		place.setFeatured(request.isFeatured());
		
		touristPlaceRepository.save(place);
		
		

		return "Tourist Place Updated Successfully";
	}
	
	// ============================
	// Delete Tourist Place
	// ============================

	public String deleteTouristPlace(Long id) {

		if (!touristPlaceRepository.existsById(id)) {
			return "Tourist Place Not Found";
		}

		touristPlaceRepository.deleteById(id);

		return "Tourist Place Deleted Successfully";
	}

	// ============================
// Get Tourist Place By Id
// ============================

	public TouristPlace getTouristPlaceById(Long id) {

    return touristPlaceRepository.findById(id).orElse(null);

}
	
}
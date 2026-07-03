package com.explore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.explore.entity.District;
import com.explore.entity.TouristPlace;

@Repository
public interface TouristPlaceRepository extends JpaRepository<TouristPlace, Long>{

	List<TouristPlace> findByDistrict(District district);

	List<TouristPlace> findByNameContainingIgnoreCase(String name);

}
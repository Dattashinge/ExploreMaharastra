package com.explore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.explore.entity.District;
import com.explore.entity.TouristPlace;

@Repository
public interface TouristPlaceRepository extends JpaRepository<TouristPlace, Long>{
	List<TouristPlace> findByNameContainingIgnoreCase(String keyword);

	List<TouristPlace> findByCategoryContainingIgnoreCase(String keyword);

	List<TouristPlace> findByDistrict_NameContainingIgnoreCase(String keyword);
	List<TouristPlace> findByDistrict(District district);

	@Query("""
			SELECT t FROM TouristPlace t
			WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
			   OR LOWER(t.category) LIKE LOWER(CONCAT('%', :keyword, '%'))
			   OR LOWER(t.description) LIKE LOWER(CONCAT('%', :keyword, '%'))
			   OR LOWER(t.location) LIKE LOWER(CONCAT('%', :keyword, '%'))
			   OR LOWER(t.famousFor) LIKE LOWER(CONCAT('%', :keyword, '%'))
			   OR LOWER(t.district.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
			""")
			List<TouristPlace> searchPlaces(@Param("keyword") String keyword);
}
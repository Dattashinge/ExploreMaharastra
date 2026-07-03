package com.explore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.explore.entity.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long>{

	boolean existsByName(String name);
	Optional<District> findById(Long id);
}
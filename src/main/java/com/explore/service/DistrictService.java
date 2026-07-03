package com.explore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.explore.entity.District;
import com.explore.repository.DistrictRepository;

@Service
public class DistrictService {

	@Autowired
	private DistrictRepository districtRepository;

	public List<District> getAllDistricts() {

		return districtRepository.findAll();

	}

	public District saveDistrict(District district) {

		return districtRepository.save(district);

	}

}
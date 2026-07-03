package com.explore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.explore.entity.District;
import com.explore.service.DistrictService;

@RestController
@RequestMapping("/api/districts")
@CrossOrigin(origins = "*")
public class DistrictController {

	@Autowired
	private DistrictService districtService;

	@GetMapping
	public List<District> getAllDistricts() {

		return districtService.getAllDistricts();

	}

}
package com.explore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.explore.entity.District;
import com.explore.repository.DistrictRepository;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private DistrictRepository districtRepository;

	@Override
	public void run(String... args) throws Exception {

		addDistrict("Ahmednagar");
		addDistrict("Akola");
		addDistrict("Amravati");
		addDistrict("Beed");
		addDistrict("Bhandara");
		addDistrict("Buldhana");
		addDistrict("Chandrapur");
		addDistrict("Chhatrapati Sambhajinagar");
		addDistrict("Dhule");
		addDistrict("Dharashiv");
		addDistrict("Gadchiroli");
		addDistrict("Gondia");
		addDistrict("Hingoli");
		addDistrict("Jalgaon");
		addDistrict("Jalna");
		addDistrict("Kolhapur");
		addDistrict("Latur");
		addDistrict("Mumbai City");
		addDistrict("Mumbai Suburban");
		addDistrict("Nagpur");
		addDistrict("Nanded");
		addDistrict("Nandurbar");
		addDistrict("Nashik");
		addDistrict("Palghar");
		addDistrict("Parbhani");
		addDistrict("Pune");
		addDistrict("Raigad");
		addDistrict("Ratnagiri");
		addDistrict("Sangli");
		addDistrict("Satara");
		addDistrict("Sindhudurg");
		addDistrict("Solapur");
		addDistrict("Thane");
		addDistrict("Wardha");
		addDistrict("Washim");
		addDistrict("Yavatmal");

		System.out.println("District Data Loaded Successfully");

	}

	private void addDistrict(String name) {

		if (!districtRepository.existsByName(name)) {

			District district = new District();

			district.setName(name);
			district.setDescription("");
			district.setImageUrl("");

			districtRepository.save(district);

		}

	}

}
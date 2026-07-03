package com.explore.service;

import java.time.LocalDateTime;
import java.util.Optional;
import com.explore.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.explore.dto.LoginRequest;
import com.explore.dto.RegisterRequest;
import com.explore.entity.User;
import com.explore.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
		
	@Autowired
	private JwtService jwtService;
	// ===========================
	// Register User
	// ===========================

	public String registerUser(RegisterRequest request) {

		// Email Exists
		if (userRepository.existsByEmail(request.getEmail())) {
			return "Email already exists.";
		}

		// Mobile Exists
		if (userRepository.existsByMobile(request.getMobile())) {
			return "Mobile number already exists.";
		}

		User user = new User();

		user.setFullName(request.getFullName());
		user.setEmail(request.getEmail());
		user.setMobile(request.getMobile());
		user.setPassword(passwordEncoder.encode(request.getPassword()));// BCrypt नंतर लावू
		user.setGender(request.getGender());
		user.setDistrict(request.getDistrict());

		user.setRole("USER");
		user.setProfileImage("default.png");
		user.setCreatedAt(LocalDateTime.now());

		userRepository.save(user);

		return "Registration Successful";

	}

	// ===========================
	// Login User
	// ===========================

	public String loginUser(LoginRequest request) {

	    User user = userRepository.findByEmail(request.getEmail())
	            .orElseThrow(() -> new RuntimeException("Invalid Email"));

	    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
	        throw new RuntimeException("Invalid Password");
	    }

	    return jwtService.generateToken(user.getEmail());
	}

}
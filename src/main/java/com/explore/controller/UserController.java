package com.explore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.explore.dto.AuthResponse;
import com.explore.dto.LoginRequest;
import com.explore.dto.RegisterRequest;
import com.explore.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;

	// =========================
	// Register API
	// =========================

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody RegisterRequest request) {

		String message = userService.registerUser(request);

		if (message.equals("Registration Successful")) {
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		}

		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	// =========================
	// Login API
	// =========================

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest request) {

	    try {

	        String token = userService.loginUser(request);

	        return ResponseEntity.ok(new AuthResponse(token));

	    } catch (Exception e) {

	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                .body(e.getMessage());

	    }

	}

}
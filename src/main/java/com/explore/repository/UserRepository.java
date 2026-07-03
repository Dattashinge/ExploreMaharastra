package com.explore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.explore.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// Check Email Exists
	boolean existsByEmail(String email);

	// Check Mobile Exists
	boolean existsByMobile(String mobile);

	// Login
	Optional<User> findByEmail(String email);

}
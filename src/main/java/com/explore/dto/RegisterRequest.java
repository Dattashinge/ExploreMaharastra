package com.explore.dto;

public class RegisterRequest {

	private String fullName;
	private String email;
	private String mobile;
	private String password;
	private String gender;
	private String district;

	// Default Constructor
	public RegisterRequest() {

	}

	// Parameterized Constructor
	public RegisterRequest(String fullName, String email, String mobile, String password, String gender,
			String district) {

		this.fullName = fullName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.gender = gender;
		this.district = district;
	}

	// Getters and Setters

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}
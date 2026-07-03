package com.explore.dto;

public class TouristPlaceRequest {

    private String name;
    private String description;
    private String history;
    private String bestTimeToVisit;
    private double entryFee;
    private String openingTime;
    private String closingTime;
    private double rating;
    private String imageUrl;
    private Long districtId;
    
    private String location;

    private String address;

    private String googleMapUrl;

    private String category;

    private String famousFor;

    private String nearestRailway;

    private String nearestAirport;
    
    private String contactNumber;

    private String website;

    private boolean featured;

    public String getContactNumber() {
		return contactNumber;
	}



	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}



	public String getWebsite() {
		return website;
	}



	public void setWebsite(String website) {
		this.website = website;
	}



	public boolean isFeatured() {
		return featured;
	}



	public void setFeatured(boolean featured) {
		this.featured = featured;
	}



	public TouristPlaceRequest() {
    }

   

    public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getGoogleMapUrl() {
		return googleMapUrl;
	}



	public void setGoogleMapUrl(String googleMapUrl) {
		this.googleMapUrl = googleMapUrl;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getFamousFor() {
		return famousFor;
	}



	public void setFamousFor(String famousFor) {
		this.famousFor = famousFor;
	}



	public String getNearestRailway() {
		return nearestRailway;
	}



	public void setNearestRailway(String nearestRailway) {
		this.nearestRailway = nearestRailway;
	}



	public String getNearestAirport() {
		return nearestAirport;
	}



	public void setNearestAirport(String nearestAirport) {
		this.nearestAirport = nearestAirport;
	}



	



	public TouristPlaceRequest(String name, String description, String history, String bestTimeToVisit, double entryFee,
			String openingTime, String closingTime, double rating, String imageUrl, Long districtId, String location,
			String address, String googleMapUrl, String category, String famousFor, String nearestRailway,
			String nearestAirport, String contactNumber, String website, boolean featured) {
		super();
		this.name = name;
		this.description = description;
		this.history = history;
		this.bestTimeToVisit = bestTimeToVisit;
		this.entryFee = entryFee;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.rating = rating;
		this.imageUrl = imageUrl;
		this.districtId = districtId;
		this.location = location;
		this.address = address;
		this.googleMapUrl = googleMapUrl;
		this.category = category;
		this.famousFor = famousFor;
		this.nearestRailway = nearestRailway;
		this.nearestAirport = nearestAirport;
		this.contactNumber = contactNumber;
		this.website = website;
		this.featured = featured;
	}



	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getBestTimeToVisit() {
        return bestTimeToVisit;
    }

    public void setBestTimeToVisit(String bestTimeToVisit) {
        this.bestTimeToVisit = bestTimeToVisit;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }
}
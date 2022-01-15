package com.example.RestaurantReview.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // creates automatically by DB
	private long id;
	private String restaurantName, type;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
	private List<Review> reviews;
	
	public Restaurant(String restaurantName, String type) {
		super();
		this.restaurantName = restaurantName;
		this.type = type;
	}
	
	public Restaurant() {};
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
	
}

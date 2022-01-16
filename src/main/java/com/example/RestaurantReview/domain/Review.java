package com.example.RestaurantReview.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String restaurantName, restaurantType, reviewer, note, value;
	private int grade;

	
	
	//constructors
	public Review() {
	}

	public Review(String restaurantName, String restaurantType, String reviewer, String note, String value, int grade) {
		super();
		this.setRestaurantName(restaurantName);
		this.setRestaurantType(restaurantType);
		this.reviewer = reviewer;
		this.note = note;
		this.grade = grade;
		this.value = value;
		
	}

	// reviewGetsets


	public long getId() {
		return id;
	}

	public void setId(long reviewid) {
		this.id = reviewid;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantType() {
		return restaurantType;
	}

	public void setRestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}

}

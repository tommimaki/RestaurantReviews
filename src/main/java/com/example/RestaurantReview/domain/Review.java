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
	private long reviewid;
	private String reviewer, note, value;
	private int grade;

	@ManyToOne
	@JoinColumn(name = "restaurantName")
	private Restaurant restaurant;

	//constructors
	public Review() {
	}

	public Review(String type, String reviewer, String note, String value, int grade, Restaurant restaurant) {
		super();
		this.reviewer = reviewer;
		this.note = note;
		this.grade = grade;
		this.value = value;
		this.restaurant = restaurant;
	}

	// reviewGetsets

	public long getId() {
		return reviewid;
	}

	public void setId(long reviewid) {
		this.reviewid = reviewid;
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

	// restaurant getsets

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}

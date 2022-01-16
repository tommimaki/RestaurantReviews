package com.example.RestaurantReview.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface ReviewRepository extends CrudRepository <Review, Long> {
	List<Review> findByrestaurantName(String restaurantName);

}

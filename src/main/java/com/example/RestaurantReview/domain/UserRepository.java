package com.example.RestaurantReview.domain;
import org.springframework.data.repository.CrudRepository;

import com.example.RestaurantReview.domain.User;



public interface UserRepository extends CrudRepository<User, Long>  {
	User findByUsername (String username);

}

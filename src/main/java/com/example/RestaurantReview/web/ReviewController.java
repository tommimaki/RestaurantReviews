package com.example.RestaurantReview.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.RestaurantReview.domain.Review;
import com.example.RestaurantReview.domain.ReviewRepository;


@CrossOrigin
@Controller
public class ReviewController {
	
	@Autowired
	private ReviewRepository rewrepository;
	
	
	// RESTful service to get all category
    @RequestMapping(value="/rewiews", method = RequestMethod.GET)
    public @ResponseBody List<Review> getCategoriesRest() {	
        return (List<Review>) rewrepository.findAll();
    }    

	// RESTful service to get category by id
    @RequestMapping(value="/reviews/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Review> findReviewsRest(@PathVariable("id") Long rewId) {	
    	return rewrepository.findById(rewId);
    } 
    
    // RESTful service to save new category
    @RequestMapping(value="/categories", method = RequestMethod.POST)
    public @ResponseBody Review saveReviewRest(@RequestBody Review review) {	
    	return rewrepository.save(review);
    }

	

}

package com.example.RestaurantReview.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	
	
	
	//defaultti
	@RequestMapping({"/", "reviewlist"})
	public String landingpage(Model model){
		model.addAttribute("reviews", rewrepository.findAll());
		return "reviewlist";
	}

	//new rew
	@RequestMapping(value="/addreview")
	public String addReview(Model model) {
		model.addAttribute("review", new Review());
		return "addreview";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveReview(Review review) {
		rewrepository.save(review);
		return "redirect:reviewlist";
	}
	
	//poisto
	
	@RequestMapping(value ="/delete/{id}", method = RequestMethod.GET)
    public String deleteReview(@PathVariable("id") Long id, Model model) {
    	rewrepository.deleteById(id);
        return "redirect:../reviewlist";
    }     
	
	
	
	
    @RequestMapping(value="/rewiews", method = RequestMethod.GET)
    public @ResponseBody List<Review> getRewievsRest() {	
        return (List<Review>) rewrepository.findAll();
    }    

	
    @RequestMapping(value="/reviews/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Review> findReviewsRest(@PathVariable("id") Long rewId) {	
    	return rewrepository.findById(rewId);
    } 
    

    @RequestMapping(value="/savereviews", method = RequestMethod.POST)
    public @ResponseBody Review saveReviewRest(@RequestBody Review review) {	
    	return rewrepository.save(review);
    }

	

}

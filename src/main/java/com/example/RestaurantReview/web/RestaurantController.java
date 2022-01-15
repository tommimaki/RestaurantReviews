package com.example.RestaurantReview.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.RestaurantReview.domain.Restaurant;
import com.example.RestaurantReview.domain.RestaurantRepository;
import com.example.RestaurantReview.domain.ReviewRepository;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantRepository resrepository;
	@Autowired
	private ReviewRepository rewrepository;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	
	
	@RequestMapping(value = {"/", "/restaurantlist" })
	public String restaurantList(Model model) {
		model.addAttribute("reviews", resrepository.findAll() );
		return "restaurantlist";		
	}
	
	@RequestMapping(value ="/add")
	public String addRestaurant(Model model)  {
		model.addAttribute("restaurant", new Restaurant());
		model.addAttribute("reviews", rewrepository.findAll() );
		return "addrestaurant"; 
	}
	
	@RequestMapping
	(value = "/save", method = RequestMethod.POST)
	public String save(Restaurant restaurant) {
		resrepository.save(restaurant);
		return "redirect:restaurantlist"; 
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteRestaurant(@PathVariable("id") Long resId, Model model) {
		resrepository.deleteById(resId);
		return "redirect:../restaurantlist";
	}
	
	
	//REST services
	
	//all restaurants
	@RequestMapping(value ="/restaurants", method = RequestMethod.GET)
	public @ResponseBody List<Restaurant> restaurantListRest() {
		return (List<Restaurant>) resrepository.findAll();		
	}
	
	//restaurant by id
	@RequestMapping(value = "/restaurants/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Restaurant> findRestaurantRest(@PathVariable("id") long resId){
		return resrepository.findById(resId);
	}
	
	//save new restaurant
	@RequestMapping(value="/restaurants", method = RequestMethod.POST)
	public @ResponseBody Restaurant saveRestaurantRest(@RequestBody Restaurant restaurant) {
		return resrepository.save(restaurant);
	}
}

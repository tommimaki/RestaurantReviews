package com.example.RestaurantReview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.RestaurantReview.domain.Review;
import com.example.RestaurantReview.domain.ReviewRepository;
import com.example.RestaurantReview.domain.User;
import com.example.RestaurantReview.domain.UserRepository;






@SpringBootApplication
public class RestaurantReviewApplication {

	private static final Logger log = LoggerFactory.getLogger(RestaurantReviewApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(RestaurantReviewApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(ReviewRepository rewrepository, UserRepository urepository) {
		return (args) -> {
			log.info("testreviw");
		
			rewrepository.save(new Review("luigis", "italian", "reviewer", "goodfood", "worth the buck", 5 ));
			rewrepository.save(new Review("marcos", "kebaba" , "Tommi", "okay, nothing special", "not worth", 2));	
		

			// user 1: u1, user
			// admin:  admin, admin
			User user = new User("user", "$2a$10$8RlLO1MZmOA3pgUI7iq1i.8Qld7/DrBFaNWaRe2l1f84GhNs8F0J2", "USER");
			User admin = new User("admin", "$2a$10$SUx2Q1/z5Kfn60CdIw5.ouj4o.z1dvS2TRXL4z/uhTFq8BWXPUiBe", "ADMIN");
			urepository.save(user);
			urepository.save(admin);
			
			log.info("fetch all reviews");
			for (Review review : rewrepository.findAll()) {
				log.info(review.toString());
			}

		};
	}


}

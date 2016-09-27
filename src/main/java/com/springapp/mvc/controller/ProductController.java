package com.springapp.mvc.controller;

import com.springapp.mvc.Enum.ProductType;
import com.springapp.mvc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;


@Controller
@RequestMapping("/")
public class ProductController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private LocationRepository locationRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		addLocation();
		addUser();
		addProduct();
		model.addAttribute("users", userRepository.findAll());
		model.addAttribute("products", productRepository.findAll());
		return "product";
	}


	@RequestMapping(value = "/allProductMain", method = RequestMethod.GET)
	public ResponseEntity getAllProduct() {
		List<Product> pp = productRepository.findAll();
		return new ResponseEntity<List<Product>>(pp,HttpStatus.NO_CONTENT);
	}



	private void addLocation() {
		if(locationRepository.count() == 0) {
			locationRepository.save(new Location("all"));
			locationRepository.save(new Location("london"));
			locationRepository.save(new Location("leeds"));
			locationRepository.save(new Location("manchester"));
			locationRepository.save(new Location("birmingham"));
			locationRepository.save(new Location("liverpool"));
		}
	}


	private void addUser() {
		//repository.deleteAll();
		if(userRepository.count() == 0) {

			userRepository.save(new User("user 1", locationRepository.findOne(1)));
			userRepository.save(new User("user 2", locationRepository.findOne(2)));
			userRepository.save(new User("user 3", locationRepository.findOne(3)));
			userRepository.save(new User("user 4", locationRepository.findOne(4)));
			userRepository.save(new User("user 5", locationRepository.findOne(5)));
			userRepository.save(new User("user 6", locationRepository.findOne(6)));

		}

	}

	private void addProduct() {
		if(productRepository.count() == 0) {
			productRepository.save(new Product("Sky News", ProductType.NEWS, locationRepository.findOne(1)));
			productRepository.save(new Product("BBC", ProductType.NEWS, locationRepository.findOne(1)));
			productRepository.save(new Product("Sky Atlantic",ProductType.ENTERTAINMENT, locationRepository.findOne(1)));
			productRepository.save(new Product("ITV",ProductType.ENTERTAINMENT, locationRepository.findOne(1)));
			productRepository.save(new Product("MTV",ProductType.MUSIC, locationRepository.findOne(1)));
			productRepository.save(new Product("Music 4",ProductType.MUSIC, locationRepository.findOne(1)));
			productRepository.save(new Product("Liverpool Tv",ProductType.SPORTS, locationRepository.findOne(6)));
			productRepository.save(new Product("Arsenal Tv",ProductType.SPORTS, locationRepository.findOne(2)));
			productRepository.save(new Product("Chelsea Tv",ProductType.SPORTS, locationRepository.findOne(2)));
			productRepository.save(new Product("ManchesterUnitedTv",ProductType.SPORTS, locationRepository.findOne(3)));
			productRepository.save(new Product("Location 4 TV",ProductType.SPORTS, locationRepository.findOne(4)));
			productRepository.save(new Product("Location 5 Tv 1",ProductType.SPORTS, locationRepository.findOne(5)));
			productRepository.save(new Product("Location 5 Tv 2",ProductType.SPORTS, locationRepository.findOne(5)));

		}
	}

}
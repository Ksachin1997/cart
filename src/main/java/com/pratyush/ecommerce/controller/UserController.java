package com.pratyush.ecommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratyush.ecommerce.model.User;
import com.pratyush.ecommerce.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/createUser")
	public String create(@RequestParam String name, @RequestParam String address, @RequestParam String type) {
		User user = userService.create(name, address, type);
		return user.toString();
	}
	
	@RequestMapping("/getUser")
	public Optional<User> get(@RequestParam String id) {
		Optional<User> user = userService.getById(id);
		return user;
	}
	
	@RequestMapping("/updateAddress")
	public String update(@RequestParam String address) {
		User user = userService.updateDetails(address);
		return user.toString();
	}
	
	@RequestMapping("/removeByType")
	public String deleteByType(@RequestParam String type) {
		userService.removeByType(type);
		return "Users of type "+type+" are removed successfully";
	}
	
	@RequestMapping("/removeAll")
	public String deleteByType() {
		userService.removeAll();
		return "All users are removed successfully";
	}
	

}

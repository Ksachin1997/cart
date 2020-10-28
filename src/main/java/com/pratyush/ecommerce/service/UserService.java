package com.pratyush.ecommerce.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratyush.ecommerce.model.User;
import com.pratyush.ecommerce.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User create(String name, String address, String type) {	
		return userRepository.save(new User(name, address, type));
	}
	
	public Optional<User> getById(String id) {
		return userRepository.findById(id);
	}
	
	public User updateDetails(String address) {
		User user = userRepository.findByAddress(address);
		user.setAddress(address);
		return userRepository.save(user);
	}
	
	public void removeAll() {
		userRepository.deleteAll();
	}
	
	public void removeByType(String type) {
		ArrayList<User> user = userRepository.findByType(type);
		userRepository.deleteAll(user);
	}
	
}

package com.pratyush.ecommerce.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pratyush.ecommerce.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	public ArrayList<User> findByType(String type);
	public User findByAddress(String address);
}

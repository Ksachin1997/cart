package com.pratyush.ecommerce.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pratyush.ecommerce.model.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String>{
	
	public ArrayList<Item> findByCategory(String category);
	public ArrayList<Item> findByPrice(int price);
	public ArrayList<Item> findByIsAvailable(boolean isAvailable);
	public Item findByItemName(String name);
}

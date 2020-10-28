package com.pratyush.ecommerce.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratyush.ecommerce.model.Item;
import com.pratyush.ecommerce.model.User;
import com.pratyush.ecommerce.repository.ItemRepository;
import com.pratyush.ecommerce.repository.UserRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Item create(String itemName, String category, int price, boolean isAvailable, int quantity) {
		Item i = itemRepository.findByItemName(itemName);
		if(i != null && i.getCategory().equalsIgnoreCase(category) && i.getPrice() == price) {
			if(i.getQuantity() == 0) {
				i.setAvailable(true);
			}
			i.setQuantity(i.getQuantity()+quantity);
			return itemRepository.save(i);
		}
		return itemRepository.save(new Item(itemName, price, category, quantity, isAvailable));
	}
	
	public String buy(String userName, String address, String itemName, int quantity) {
		User user = userRepository.findByAddress(address);
		if(user == null || user.getName().equalsIgnoreCase(userName) == false) {
			return "You need to SignUp first!!!";
		}
		
		Item item = itemRepository.findByItemName(itemName);
		if(item == null) {
			return "Item not found!!!";
		}
		if(item.getQuantity() < quantity) {
			return "Available quantity is "+item.getQuantity()+" please lower the quantity of Order";
		}
		if(item.getQuantity() == quantity) {
			item.setAvailable(false);
		}
		item.setQuantity(item.getQuantity()-quantity);
		itemRepository.save(item);
		return "Order Placed Successfully. Please pay "+item.getPrice()*quantity;
	}
	
	public String addToCart(String itemName, int quantity, String userName, String address) {
		User user = userRepository.findByAddress(address);
		
		Item item = itemRepository.findByItemName(itemName);
		user.cart.add(item);
		
		return "Item added to cart";
	}
		
	
	
	public ArrayList<Item> getByCategory(String category){
		
		return itemRepository.findByCategory(category);
	}
	
	public ArrayList<Item> getByPrice(int price){
		
		return itemRepository.findByPrice(price);
	}
	
	public ArrayList<Item> getByIsAvailable(Boolean isAvailable){
		return itemRepository.findByIsAvailable(isAvailable);
	}
	
	public Item getByItemName(String itemName) {
		return itemRepository.findByItemName(itemName);
	}
	
	public String removeAll(String userName, String type, String address) {
		User user = userRepository.findByAddress(address);
		if(user == null || user.getName().equalsIgnoreCase(userName) == false) {
			return "You need to SignUp first!!!";
		}
		if(user.getType().equalsIgnoreCase("Customer")) {
			return "Only Admin can remove Item from database";
		}
		itemRepository.deleteAll();
		return "All items removed";
	}
	
	public String removeByCategory(String category, String userName, String type, String address) {
		User user = userRepository.findByAddress(address);
		if(user == null || user.getName().equalsIgnoreCase(userName) == false) {
			return "You need to SignUp first!!!";
		}
		if(user.getType().equalsIgnoreCase("Customer")) {
			return "Only Admin can remove Item from database";
		}
		itemRepository.deleteAll(itemRepository.findByCategory(category));
		return "All items removed with given category";
	}
	
	public String removeByName(String itemName, String userName, String type, String address) {
		User user = userRepository.findByAddress(address);
		if(user == null || user.getName().equalsIgnoreCase(userName) == false) {
			return "You need to SignUp first!!!";
		}
		if(user.getType().equalsIgnoreCase("Customer")) {
			return "Only Admin can remove Item from database";
		}
		itemRepository.delete(itemRepository.findByItemName(itemName));
		return "Items removed with given name";
	}

}

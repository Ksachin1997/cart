package com.pratyush.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratyush.ecommerce.model.Item;
import com.pratyush.ecommerce.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/createItem")
	public String create(@RequestParam String itemName, @RequestParam String category, @RequestParam int price, @RequestParam boolean isAvailable, @RequestParam int quantity) {
		Item item = itemService.create(itemName, category, price, isAvailable, quantity);
		return item.toString();
	}
	
	@RequestMapping("/buy")
	public String buy(@RequestParam String userName, @RequestParam String address, @RequestParam String itemName, @RequestParam int quantity) {
		return itemService.buy(userName, address, itemName, quantity);
	}
	


}

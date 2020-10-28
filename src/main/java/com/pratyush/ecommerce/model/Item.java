package com.pratyush.ecommerce.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Item {
	
	@Id
	private String id;
	private String itemName;
	private int price;
	private String category;
	int quantity;
	private boolean isAvailable;
	
	public Item(String itemName, int price, String category, int quantity, boolean isAvailable) {
		this.itemName = itemName;
		this.category = category;
		this.price = price;
		this.isAvailable = isAvailable;
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", price=" + price + ", category=" + category + ", isAvailable="
				+ isAvailable + "]";
	}
	
}

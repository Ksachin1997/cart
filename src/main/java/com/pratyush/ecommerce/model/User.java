package com.pratyush.ecommerce.model;

import java.util.LinkedList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	
	@Id
	private String id;
	private String name;
	private String address;
	private String type;
	public LinkedList<Item> cart;
	
	
	public User(String name, String address, String type) {
		this.name = name;
		this.address = address;	
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public boolean validateType() {
		if(this.type.equalsIgnoreCase("Customer") || this.type.equalsIgnoreCase("Admin"))
			return true;
		return false;
	}
	

	public String toString() {
		return "Name : "+this.name+" "+"Address : "+this.address+" "+"User Type : "+this.type;
	}

}

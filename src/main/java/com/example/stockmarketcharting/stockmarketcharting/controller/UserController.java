package com.example.stockmarketcharting.stockmarketcharting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockmarketcharting.stockmarketcharting.entity.User;
import com.example.stockmarketcharting.stockmarketcharting.response.Response;
import com.example.stockmarketcharting.stockmarketcharting.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/register")
	public Response registerUser(@RequestBody User user) {
		boolean uniqueEmail = service.isEmailUnique(user.getEmail());
		if(!uniqueEmail) {
			return new Response(false, "Please use different Email!");
		}
		
		boolean uniqueUsername = service.isUsernameUnique(user.getUsername());
		if(!uniqueUsername) {
			return new Response(false, "Please use different username!");
		}
		
		boolean uniqueMobileNumber = service.isMobileNumberUnique(user.getMobileNumber());
		if(!uniqueMobileNumber) {
			return new Response(false, "Please use different Mobile Number!");
		}
		
		User savedUser = service.saveUser(user);
		if(savedUser != null) {
			return new Response(true, "User created Successfully!");
		}
		
		return new Response(false, "We ran into some problem. Please hold tight while we fix it up!");
	}
}

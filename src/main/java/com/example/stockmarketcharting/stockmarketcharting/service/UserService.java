package com.example.stockmarketcharting.stockmarketcharting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockmarketcharting.stockmarketcharting.entity.User;
import com.example.stockmarketcharting.stockmarketcharting.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public boolean isEmailUnique(String email) {
		User user = repository.findByEmail(email);
		if(user != null) {
			return false;
		} else {
			return true;
		}
	}
}

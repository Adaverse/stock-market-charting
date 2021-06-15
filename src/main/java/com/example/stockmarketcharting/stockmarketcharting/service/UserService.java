package com.example.stockmarketcharting.stockmarketcharting.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockmarketcharting.stockmarketcharting.entity.User;
import com.example.stockmarketcharting.stockmarketcharting.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public User findById(int id) {
		return repository.findById(id).orElse(null);
	}
	
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
	
	public boolean isUsernameUnique(String username) {
		User user = repository.findByUsername(username);
		if(user != null) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean isMobileNumberUnique(Long mobileNumber) {
		User user = repository.findByMobileNumber(mobileNumber);
		if(user != null) {
			return false;
		} else {
			return true;
		}
	}
}

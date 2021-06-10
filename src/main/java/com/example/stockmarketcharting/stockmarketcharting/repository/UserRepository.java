package com.example.stockmarketcharting.stockmarketcharting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stockmarketcharting.stockmarketcharting.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

package com.example.stockmarketcharting.stockmarketcharting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stockmarketcharting.stockmarketcharting.entity.Ipo;

public interface IpoRespository extends JpaRepository<Ipo, Integer> {

}

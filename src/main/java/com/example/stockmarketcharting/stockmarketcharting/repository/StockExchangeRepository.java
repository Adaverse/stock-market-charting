package com.example.stockmarketcharting.stockmarketcharting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stockmarketcharting.stockmarketcharting.entity.StockExchange;

public interface StockExchangeRepository extends JpaRepository<StockExchange, Integer> {

}

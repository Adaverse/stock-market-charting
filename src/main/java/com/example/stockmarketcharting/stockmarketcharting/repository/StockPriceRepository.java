package com.example.stockmarketcharting.stockmarketcharting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stockmarketcharting.stockmarketcharting.entity.StockPrice;

public interface StockPriceRepository extends JpaRepository<StockPrice, Integer>{

}

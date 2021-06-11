package com.example.stockmarketcharting.stockmarketcharting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stockmarketcharting.stockmarketcharting.entity.CompanyCode;

public interface CompanyCodeRepository extends JpaRepository<CompanyCode, Integer>{

}

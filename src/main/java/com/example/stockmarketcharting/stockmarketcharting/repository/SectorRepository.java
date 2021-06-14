package com.example.stockmarketcharting.stockmarketcharting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stockmarketcharting.stockmarketcharting.entity.Company;
import com.example.stockmarketcharting.stockmarketcharting.entity.Sector;

public interface SectorRepository extends JpaRepository<Sector, Integer>{

}

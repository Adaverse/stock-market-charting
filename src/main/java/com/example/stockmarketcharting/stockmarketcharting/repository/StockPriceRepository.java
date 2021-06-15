package com.example.stockmarketcharting.stockmarketcharting.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.stockmarketcharting.stockmarketcharting.entity.StockPrice;

public interface StockPriceRepository extends JpaRepository<StockPrice, Integer>{

	@Query("SELECT s FROM STOCK_PRICE s WHERE s.date BETWEEN ?1 AND ?2 AND COMPANY_CODE_ID = ?3")
	public List<StockPrice> getStockPriceByDates(Date from, Date to, int companyCodeId);
	
}

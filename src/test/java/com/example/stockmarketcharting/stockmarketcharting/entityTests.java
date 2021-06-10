package com.example.stockmarketcharting.stockmarketcharting;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.stockmarketcharting.stockmarketcharting.entity.User;

@SpringBootTest
public class entityTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	void userEntityTest () {
		logger.info("test passed");
	}
}

package com.example.stockmarketcharting.stockmarketcharting.serviceTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.stockmarketcharting.stockmarketcharting.entity.User;
import com.example.stockmarketcharting.stockmarketcharting.repository.UserRepository;
import com.example.stockmarketcharting.stockmarketcharting.service.UserService;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

	@InjectMocks
	UserService userService;
	
	@Mock
	UserRepository userRepository;
	
	@Test
	public void testIsEmailUnique() {
		User user = new User("abc@gmail.com", "username", "password", 9437124067L, false);
		Mockito.when(userRepository.findByEmail("abc@gmail.com")).thenReturn(user);
		
		boolean result = userService.isEmailUnique("abc@gmail.com");
		assertFalse(result);
		
		boolean result1 = userService.isEmailUnique("abc1@gmail.com");
		assertTrue(result1);
	}
	
}

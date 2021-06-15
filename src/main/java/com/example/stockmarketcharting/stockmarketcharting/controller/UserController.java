package com.example.stockmarketcharting.stockmarketcharting.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockmarketcharting.stockmarketcharting.entity.User;
import com.example.stockmarketcharting.stockmarketcharting.response.Response;
import com.example.stockmarketcharting.stockmarketcharting.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	String myMail = "TLTDadaverse@gmail.com";
	String myPassword = "simplePassword@";
	String URL = "http://localhost:8080/comfirmUser/";
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/register")
	public Response registerUser(@RequestBody User user) throws AddressException, MessagingException {
		boolean uniqueEmail = service.isEmailUnique(user.getEmail());
		if(!uniqueEmail) {
			return new Response(false, "Please use different Email!");
		}
		
		boolean uniqueUsername = service.isUsernameUnique(user.getUsername());
		if(!uniqueUsername) {
			return new Response(false, "Please use different username!");
		}
		
		boolean uniqueMobileNumber = service.isMobileNumberUnique(user.getMobileNumber());
		if(!uniqueMobileNumber) {
			return new Response(false, "Please use different Mobile Number!");
		}
		
		User savedUser = service.saveUser(user);
		if(savedUser != null) {
			sendEmail(savedUser.getId());
			return new Response(true, "User created Successfully. Confirm the email to complete the registration process!");
		}
		
		return new Response(false, "We ran into some problem. Please hold tight while we fix it up!");
	}
	
	public void sendEmail(int id) throws AddressException, MessagingException {
		User user = service.findById(id);
        final String username = myMail;
        final String password = myPassword;
        final String userEmail = user.getEmail();

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                        return new javax.mail.PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myMail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(userEmail)
            );
            message.setSubject("User confirmation email");
      
            message.setContent(
            		"<h1><a href =" + "\"" + URL + Integer.toString(id) + "/" + "\"" +"> Click to confirm </a></h1>",
                   "text/html");
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
	
	@GetMapping("/comfirmUser/{id}")
	public String confirmUser(@PathVariable int id) {
		User user = service.findById(id);
		user.setConfirmed(true);
		User tempUser = service.saveUser(user);
		if( tempUser != null){
			return "You are verified";
		}
		return "We ran into some problem!";
	}
}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.entity.User;

@RestController
@RequestMapping("/public")
public class PublicController {

	 @Autowired
	    private UserService userService;
	@GetMapping("/health-cheacking")
	public String healthCheach() {
		return"ok";
	}
	   @PostMapping("/create-user")
	    public void createUser(@RequestBody User user) {
	        userService.saveNewUser(user);
    }
}

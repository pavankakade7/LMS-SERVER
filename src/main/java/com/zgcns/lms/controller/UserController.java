package com.zgcns.lms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zgcns.lms.model.User;
import com.zgcns.lms.services.UserService;

import lombok.AllArgsConstructor;



@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	public final UserService userService;
	
	public UserController(UserService userService)
	{
		this.userService = userService;
	}
	
	
	@PostMapping("/adduser")
	public String addUser(@RequestBody User user) {
		return userService.addUser(user);
	
	}	
	
	@PostMapping("/authuser")
	public String authenticateUser(@RequestBody User user) {
		return userService.authenticateUser(user);
	}
	
	@PutMapping("/updateuser/{userId}")
	public User UpdatedUser(@PathVariable("userId") long userId, @RequestBody User user) {
		return userService.Updateuser(userId, user);
	}
	

}

package com.avi.userService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avi.userService.entity.ResponseUserDTO;
import com.avi.userService.entity.User;
import com.avi.userService.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User addUser(@RequestBody User user) {
		log.info("userController :: addUser");
		return userService.addUser(user);
	}
	
	@GetMapping("/{userId}")
	public ResponseUserDTO getUser(@PathVariable Long userId) {
		log.info("userController :: getUser");
		return userService.getUser(userId);
	}
	
	@GetMapping("/testPath")
	public String testService(@PathVariable String testPath) {
		log.info("userController :: getUser");
		return "Service Running...";
	}
}

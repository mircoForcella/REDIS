package com.example.REDIS.controllers;

import com.example.REDIS.entities.User;
import com.example.REDIS.entities.UserJPA;
import com.example.REDIS.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class Controller {
	@Autowired
	private UserService userService;
	
	@PostMapping
	public UserJPA post(@RequestBody UserJPA user){
		return userService.createUser(user);
	}
	@GetMapping("/{id}")
	public UserJPA get(@PathVariable Long id){
		return userService.readUser(id);
	}
	@PutMapping
	public UserJPA put(@RequestBody UserJPA user){
		return userService.updateUser(user);
	}
	@DeleteMapping("/{id}")
	public void del(@PathVariable Long id){
		userService.deleteUser(id);
	}
}

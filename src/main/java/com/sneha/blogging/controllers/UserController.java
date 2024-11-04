package com.sneha.blogging.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sneha.blogging.payloads.APIReasponse;
import com.sneha.blogging.payloads.UserDto;
import com.sneha.blogging.services.UserService;

import jakarta.transaction.Status;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Create	
	@PostMapping("/user")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){		
		UserDto createdUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
	}
	
	//Update	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer id){
		
		UserDto updatedUser = this.userService.updateUser(userDto, id);
		return ResponseEntity.ok(updatedUser);
	}	
	
	//Get
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable("userId") Integer id){
		return ResponseEntity.ok(this.userService.getUser(id));
	}
	
	//Delete
	@DeleteMapping("/{userId}")
	public ResponseEntity<APIReasponse> deletUser(@PathVariable("userId") Integer id){
		this.userService.deleteUser(id);
		return new ResponseEntity<APIReasponse>(new APIReasponse("User deleted successfully", true), HttpStatus.OK);
	}
	
	//GetAll
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUser());
	}
	
	
}

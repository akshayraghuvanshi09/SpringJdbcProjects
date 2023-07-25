package com.hurix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hurix.helper.UserPaginationResponse;
import com.hurix.model.User;
import com.hurix.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<String> createUser(@RequestBody User user){
		Boolean isCreated = userService.createUser(user);
		if (isCreated) {
			return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully!");
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
		}
	}
	
	@GetMapping("/get")
	public ResponseEntity<UserPaginationResponse> getAllUser(@RequestParam(required = false ) String city,
												@RequestParam(required = false, defaultValue = "0") Integer pageNo,
												@RequestParam(required = false, defaultValue = "10") Integer pageSize,
												@RequestParam(required = false , defaultValue = "id") String sortBy,
												@RequestParam(required = false, defaultValue = "ASC") String sortDirection
			){
		
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers(city, pageNo, pageSize, sortBy, sortDirection));
	}
}

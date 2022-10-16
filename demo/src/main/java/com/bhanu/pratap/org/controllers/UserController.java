package com.bhanu.pratap.org.controllers;

import java.util.List;

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

import com.bhanu.pratap.org.payloads.ApiResponse;
import com.bhanu.pratap.org.payloads.UserDto;
import com.bhanu.pratap.org.sercives.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// to create User
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

	// to update user
	
	@PutMapping("/{userId}") 
	//here userId is a pathUri variable
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer uId){
		UserDto updateUserDto =  this.userService.updateUser(userDto, uId);
		return new ResponseEntity<>(updateUserDto, HttpStatus.OK);
	}
	
	// to delete user
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") int uid){
		  this.userService.deleteUser(uid);
		
//		return new ResponseEntity<>(Map.of("meassage", "User Deleted Sucessfully"),HttpStatus.OK);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getSingleUser(@PathVariable("userId") int uid){
		UserDto userDto = this.userService.getUserById(uid);
		return ResponseEntity.ok(userDto);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
//		List<UserDto> userList = this.userService.getAllUsers();
//		return ResponseEntity.ok(userList);
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
}

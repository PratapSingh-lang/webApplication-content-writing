package com.bhanu.pratap.org.sercives;

import java.util.List;

import com.bhanu.pratap.org.payloads.UserDto;


public interface UserService {
			
	 UserDto createUser(UserDto user);
	 UserDto updateUser(UserDto user, Integer userId);
	 UserDto getUserById(Integer userId);
	 List<UserDto> getAllUsers();
	 void deleteUser( Integer userId);
	 
}

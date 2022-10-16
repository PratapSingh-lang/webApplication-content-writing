package com.bhanu.pratap.org.sercives.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhanu.pratap.org.entities.User;
import com.bhanu.pratap.org.exceptions.ResourceNotFoundException;
import com.bhanu.pratap.org.payloads.UserDto;
import com.bhanu.pratap.org.repositories.UserRepo;
import com.bhanu.pratap.org.sercives.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		
		UserDto savedUserDto = this.userToDto(savedUser);
		return savedUserDto;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		User user =  this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"User", "Id", userId
						));
		user.setName(userDto.getName());
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		
		User updateUser = this.userRepo.save(user);
		
		UserDto updateUserDto = this.userToDto(updateUser);
		
		
		return updateUserDto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"User", "Id", userId
						));
		UserDto getUserDto = this.userToDto(user);
		return getUserDto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = this.userRepo.findAll();
		
		List<UserDto> userDtos = users.stream()
									.map(user -> this.userToDto(user))
									.collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"userId", "id", userId
						));
		this.userRepo.delete(user);

	}
	
	private User dtoToUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		return user;
	}
	
	private UserDto userToDto(User user) {
		UserDto userDto =  new UserDto();
		userDto.setId(user.getId());
		userDto.setAbout(user.getAbout());
		userDto.setEmail(user.getEmail());
		userDto.setName(user.getName());
		userDto.setPassword(user.getPassword());
		return userDto;
	}

}

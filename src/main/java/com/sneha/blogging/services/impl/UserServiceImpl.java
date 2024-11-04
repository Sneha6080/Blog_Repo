package com.sneha.blogging.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sneha.blogging.entities.User;
import com.sneha.blogging.exceptions.ResourceNotFoundException;
import com.sneha.blogging.payloads.UserDto;
import com.sneha.blogging.repositories.UserRepo;
import com.sneha.blogging.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
    	User user = this.dtoToUser(userDto);
		User createdUser = this.userRepo.save(user);
		return this.userToDto(createdUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer id) {
		User user = this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("userId", "user", id));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepo.save(user);
		return this.userToDto(updatedUser);
	}

	@Override
	public void deleteUser(Integer id) {
		User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("userId", "user", id));
		this.userRepo.delete(user);
		
	}

	@Override
	public UserDto getUser(Integer id) {
		User user = this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("userId", "user", id));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> usersDto = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return usersDto;
	}
	
	private User dtoToUser(UserDto userDto) {
	  User user = this.modelMapper.map(userDto, User.class);
//	  user.setId(userDto.getId());
//      user.setName(userDto.getName());
//      user.setEmail(userDto.getEmail());
//      user.setPassword(userDto.getPassword());
//      user.setAbout(userDto.getAbout());
      
      return user;
	}
	
	private UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);		
		return userDto;
	}

}

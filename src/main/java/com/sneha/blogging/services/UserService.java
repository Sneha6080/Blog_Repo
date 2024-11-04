package com.sneha.blogging.services;

import java.util.List;

import com.sneha.blogging.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto userDto, Integer id);
	void deleteUser(Integer id);
	UserDto getUser(Integer id);
	List<UserDto> getAllUser();
}

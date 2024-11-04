//package com.sneha.blogging.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.sneha.blogging.entities.User;
//import com.sneha.blogging.exceptions.ResourceNotFoundException2;
//import com.sneha.blogging.repositories.UserRepo;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
//
//	@Autowired
//	private UserRepo userRepo;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		//Loading user from Database using username
//		User user = this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException2("User", "username", username));
//		
//		return user;
//	}
//
//}

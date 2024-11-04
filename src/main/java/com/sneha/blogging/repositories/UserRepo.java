package com.sneha.blogging.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sneha.blogging.entities.User;
import java.util.List;


public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
}

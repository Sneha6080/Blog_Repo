package com.sneha.blogging.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sneha.blogging.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}

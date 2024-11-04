package com.sneha.blogging.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sneha.blogging.entities.Category;
import com.sneha.blogging.entities.Post;
import com.sneha.blogging.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
//	List<Post> findAllPost();
	
	List<Post> findByTitleContaining(String keywords);
	
	@Query("select p from Post p where p.title like : key")
	List<Post> searchByTitle(@Param("key") String title);
}

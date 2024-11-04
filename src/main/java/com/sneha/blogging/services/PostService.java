package com.sneha.blogging.services;

import java.util.List;

import com.sneha.blogging.entities.Post;
import com.sneha.blogging.payloads.PostDto;
import com.sneha.blogging.payloads.PostResponse;


public interface PostService {

	//Create	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//Update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//Delete
	void delete(Integer postId);
	
	//Get specific post
	PostDto getPost(Integer postId);
	
	//Get all posts
	PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	//Get all post of specific user 
	List<PostDto> getAllPostByUser(Integer userId);
	
	//Get all post of specific category
	List<PostDto> getAllPostByCategory(Integer categoryId);
	
	//Search Post
	List<PostDto> searchPosts(String keyWord);
}

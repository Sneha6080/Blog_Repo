package com.sneha.blogging.services;

import com.sneha.blogging.entities.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer postId);
	
	CommentDto updateComment(CommentDto commentDto, Integer commentId);
	
	void deleteComment(Integer commentId);
}

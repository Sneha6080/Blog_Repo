package com.sneha.blogging.services.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sneha.blogging.entities.Comment;
import com.sneha.blogging.entities.CommentDto;
import com.sneha.blogging.entities.Post;
import com.sneha.blogging.exceptions.ResourceNotFoundException;
import com.sneha.blogging.repositories.CommentRepo;
import com.sneha.blogging.repositories.PostRepo;
import com.sneha.blogging.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","Post id", postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment);
			
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public CommentDto updateComment(CommentDto commentDto, Integer commentId) {
		Comment comment = this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment", "Comment Id", commentId));
		comment.setContent(commentDto.getContent());
		comment.setId(commentDto.getId());
		Comment updatedComment = this.commentRepo.save(comment);
		return this.modelMapper.map(updatedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment", "Comment Id", commentId));
		this.commentRepo.delete(comment);
	}

	
}

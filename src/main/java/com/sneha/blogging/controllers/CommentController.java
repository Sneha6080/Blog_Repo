package com.sneha.blogging.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sneha.blogging.entities.CommentDto;
import com.sneha.blogging.payloads.APIReasponse;
import com.sneha.blogging.services.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,@PathVariable Integer postId) {
		CommentDto createdComment = this.commentService.createComment(commentDto, postId);
		return new ResponseEntity<CommentDto>(createdComment, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/comments/{commentId}")
	public ResponseEntity<APIReasponse> updateComment(@RequestBody CommentDto commentDto,@PathVariable Integer commentId){
		CommentDto updatedComment = this.commentService.updateComment(commentDto, commentId);
		return new ResponseEntity<APIReasponse>(new APIReasponse("Comment updated successfully", true), HttpStatus.OK);
	}
	
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<APIReasponse> deleteComment(@PathVariable Integer commentId){
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<APIReasponse>(new APIReasponse("Comment deleted successfully", true), HttpStatus.OK);
	}

}

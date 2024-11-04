package com.sneha.blogging.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sneha.blogging.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}

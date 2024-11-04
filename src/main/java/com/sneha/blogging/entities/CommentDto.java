package com.sneha.blogging.entities;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentDto {

    private int id;
	
	private String content;	
	
}

package com.sneha.blogging.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.sneha.blogging.entities.CommentDto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Integer postId;	

    @NotEmpty
	private String title;
	
    @NotEmpty
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private Set<CommentDto> comments = new HashSet<>();
}

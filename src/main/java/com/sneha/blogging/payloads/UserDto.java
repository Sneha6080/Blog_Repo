package com.sneha.blogging.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	
	@NotEmpty
	@Size(min = 4, message = "Name must be min of 4 characters")
	private String name;
	
	@Email(message = "Enter valid email address")
	private String email;
	
	@NotEmpty
	@Size(min = 5, max = 8, message = "password must be minimum of 4 and maximum of 8 characters")
	private String password;
	
	@NotEmpty(message = "please enter info")
	private String about;
}

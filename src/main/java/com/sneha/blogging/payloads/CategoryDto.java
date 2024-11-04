package com.sneha.blogging.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	
	private Integer categoryId;
	
	@NotEmpty
	@Size(min = 4, max = 100, message = "Please enter the title minimum of 4 character and maximum of 100")
	private String categoryTitle;
	
	@NotEmpty
	@Size(min = 10)
	private String categoryDescription;
}

package com.sneha.blogging.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException2 extends RuntimeException {

	String resourceName;
	String fieldname;
	String fieldValue;
	
	
	public ResourceNotFoundException2(String resourceName, String fieldname, String fieldValue) {
		super(String.format("%s not found with %s : %s", resourceName, fieldname, fieldValue));
		this.resourceName = resourceName;
		this.fieldname = fieldname;
		this.fieldValue = fieldValue;
	}
}

package com.bhanu.pratap.org.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	String resourceName;
	String fileldName;
	long fieldValue;
	public ResourceNotFoundException(
			String resourceName, String fieldName, long fieldValue
			) {
		super(String.format("not fpound"
				, resourceName, fieldName, fieldValue )
				);
		this.resourceName = resourceName;
		this.fileldName = fieldName;
		this.fieldValue = fieldValue;
	}
}

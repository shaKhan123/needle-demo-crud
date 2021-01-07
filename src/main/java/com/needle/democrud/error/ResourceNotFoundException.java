package com.needle.democrud.error;

public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 2644546430822275669L;

	public ResourceNotFoundException() {

		super("No data found");
	}
}
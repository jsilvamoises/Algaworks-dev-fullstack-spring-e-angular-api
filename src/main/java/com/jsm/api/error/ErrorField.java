package com.jsm.api.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorField extends DefaultError{

	private static final long serialVersionUID = 1L;
	
	private List<ObjectField> fields = new ArrayList<>();

	public List<ObjectField> getFields() {
		return fields;
	}

	public ErrorField() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorField(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
		// TODO Auto-generated constructor stub
	}

	
	
	

}

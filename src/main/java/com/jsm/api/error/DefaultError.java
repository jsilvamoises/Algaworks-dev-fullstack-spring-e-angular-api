package com.jsm.api.error;

import java.io.Serializable;

public class DefaultError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long timestamp;
	private Integer status;
	private String error;
	
	
	private String message;
	private String path;
	
	public DefaultError(Long timestamp, Integer status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	
	
	public DefaultError() {		
	}


	public Long getTimestamp() {
		return timestamp;
	}


	public DefaultError setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
		return this;
	}


	public Integer getStatus() {
		return status;
	}


	public DefaultError setStatus(Integer status) {
		this.status = status;
		return this;
	}


	public String getError() {
		return error;
	}


	public DefaultError setError(String error) {
		this.error = error;
		return this;
	}


	public String getMessage() {
		return message;
	}


	public DefaultError setMessage(String message) {
		this.message = message;
		return this;
	}


	public String getPath() {
		return path;
	}


	public DefaultError setPath(String path) {
		this.path = path;
		return this;
	}
	
	
	
}

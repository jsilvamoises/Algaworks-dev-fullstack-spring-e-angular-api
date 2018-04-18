package com.jsm.api.error;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException() {
		super();
		
	}

	public ObjectNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

	public ObjectNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public ObjectNotFoundException(String arg0) {
		super(arg0);
		
	}

	public ObjectNotFoundException(Throwable arg0) {
		super(arg0);
		
	}

}

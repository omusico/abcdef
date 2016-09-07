package com.lvmama.lvf.common.convert.exception;

public class ResourceNotExistException extends Exception {
	
	private static final long serialVersionUID = -2272770181169257143L;

	public ResourceNotExistException() {
		super();
	}

	public ResourceNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotExistException(String message) {
		super(message);
	}

	public ResourceNotExistException(Throwable cause) {
		super(cause);
	}
	
}

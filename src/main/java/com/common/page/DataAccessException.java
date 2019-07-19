package com.common.page;

/**
 * 
 * @author loudyn
 * 
 */
public class DataAccessException extends RuntimeException {

	/**
	 * 
	 * @param message
	 */
	public DataAccessException(String message) {
		super(message);
	}

	public DataAccessException(Throwable cause) {
		super(cause);
	}
	
	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	private static final long serialVersionUID = 1L;

}

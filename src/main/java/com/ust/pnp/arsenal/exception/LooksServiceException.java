package com.ust.pnp.arsenal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class LooksServiceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3441419746030591348L;

	public LooksServiceException(String message) {
		super(message);
	}

}

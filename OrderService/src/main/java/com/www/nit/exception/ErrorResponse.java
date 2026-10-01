package com.www.nit.exception;

public class ErrorResponse {
	
	private String status;
	private String errorCode;
	private Object message;
	
	public ErrorResponse() {
		super();
	}
	
	public ErrorResponse(String status,String errorCode, Object message) {
		super();
		this.status=status;
		this.errorCode=errorCode;
		this.message=message;
	}

	public String getStatus() {
		return status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public Object getMessage() {
		return message;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setMessage(Object message) {
		this.message = message;
	}
	
}

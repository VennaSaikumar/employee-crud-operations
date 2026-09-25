package com.nit.exception;

public class ErrorResponse {
	
	private String status;
    private String errorCode;
    private Object message;
    
    public ErrorResponse() {
	}
    
    public ErrorResponse(String status, String errorCode, Object message) {
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	
    
    

}
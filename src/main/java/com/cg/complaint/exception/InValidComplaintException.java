package com.cg.complaint.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class InValidComplaintException extends RuntimeException
{
	public InValidComplaintException(String message){
	        super(message);
	    }
}

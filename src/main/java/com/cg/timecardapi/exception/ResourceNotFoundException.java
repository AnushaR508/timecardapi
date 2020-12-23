package com.cg.timecardapi.exception;
/**Author: Theja Nadhella
 * Project Desc: Time Card Service
 * Desc: Resource Not found class is called whenever attribute is not available when it is called
 */
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message){
    	super(message);  
    }
}

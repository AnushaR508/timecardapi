package com.cg.timecardapi.exception;

/**Author: Theja Nadhella
 * Project Desc: Time Card Service
 * Desc: Error details class holds time stamp details of all possible errors in console
 */
import java.util.Date;

public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;

	/**Parameterized Constructor
	 * @param timestamp
	 * @param message
	 * @param details
	 */
	public ErrorDetails(Date timestamp, String message, String details) { 
		this.timestamp = timestamp;
		this.message = message;
		this.details = details; 
	}

	/**getters and setters
	 * @return
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}

/**
 * 
 */
package org.ness.com.springav.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author P7108899
 *
 */
@XmlRootElement(name = "error")
public class ErrorResponse {

	/**
	 * 
	 */
	public ErrorResponse() {
		// TODO Auto-generated constructor stub
	}

	private String message;
	private List<String> details;
	
	/**
	 * @param message
	 * @param details
	 */
	public ErrorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the details
	 */
	public List<String> getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(List<String> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		
		return "[message=" + message + ", details=" + details + "]";
	}
}

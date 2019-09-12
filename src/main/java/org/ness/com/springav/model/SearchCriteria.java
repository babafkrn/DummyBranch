/**
 * 
 */
package org.ness.com.springav.model;

import javax.validation.constraints.NotBlank;

/**
 * @author P7108899
 *
 */
public class SearchCriteria {

	@NotBlank(message = "Status cannot be blank")
	private String status;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}

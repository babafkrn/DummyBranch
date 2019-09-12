/**
 * 
 */
package org.ness.com.springav.model;

import java.util.List;

/**
 * @author P7108899
 *
 */
public class AjaxSearchResponseBody {

	private String message;
	
	private List<Todos> todosList;

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
	 * @return the todosList
	 */
	public List<Todos> getTodosList() {
		return todosList;
	}

	/**
	 * @param todosList the todosList to set
	 */
	public void setTodosList(List<Todos> todosList) {
		this.todosList = todosList;
	}
}

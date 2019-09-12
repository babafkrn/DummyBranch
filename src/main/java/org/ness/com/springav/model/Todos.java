/**
 * 
 */
package org.ness.com.springav.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author P7108899
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Todos.findTodosByStatus", query = "select t from Todos t where t.status=?1"),
	@NamedQuery(name = "Todos.findTodoByStatusAndIdAndDescription", query = "select t from Todos t where t.status = ?1 and t.id=?2 and t.description=?3")
})
public class Todos {

	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private String status;
	private Date date;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
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
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		
		return "Todo: [" + "id= " + id + " , description=" + description + " , status=" + status + ", date=" + date + "]";
	}
}

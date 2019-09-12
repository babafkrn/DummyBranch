/**
 * 
 */
package org.ness.com.springav.service;

import java.util.List;

import org.ness.com.springav.model.Todos;

/**
 * @author P7108899
 *
 */
public interface TodosSearchService {

	public List<Todos> findTodosByStatus(String status);
}

/**
 * 
 */
package org.ness.com.springav.service;

import java.util.List;
import org.ness.com.springav.model.Todos;
import org.ness.com.springav.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author P7108899
 *
 */
@Service
public class TodosSearchServiceImpl implements TodosSearchService {

	@Autowired
	private TodosRepository todosRepository;
	
	@Override
	public List<Todos> findTodosByStatus(String status) {

		return todosRepository.findByStatus(status);
	}
}

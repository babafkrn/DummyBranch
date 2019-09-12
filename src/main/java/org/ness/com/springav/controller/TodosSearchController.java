/**
 * 
 */
package org.ness.com.springav.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.ness.com.springav.model.AjaxSearchResponseBody;
import org.ness.com.springav.model.SearchCriteria;
import org.ness.com.springav.model.Todos;
import org.ness.com.springav.service.TodosSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author P7108899
 *
 */
@RestController
public class TodosSearchController {

	@Autowired
	private TodosSearchService todosSearchService; 
	
	@PostMapping("/todos-search")
	public ResponseEntity<?> findTodosByStatus(@Valid @RequestBody SearchCriteria searchCriteria, Errors errors) {
		
		AjaxSearchResponseBody ajaxSearchResponseBody = new AjaxSearchResponseBody();
		
		// if error then return 400 bad request along with the error message
		if(errors.hasErrors()) {
			
			ajaxSearchResponseBody.setMessage(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
			
			ResponseEntity.badRequest().body(ajaxSearchResponseBody);
		}
		
		List<Todos> todosList = todosSearchService.findTodosByStatus(searchCriteria.getStatus());
		
		if(todosList.isEmpty()) {
			
			ajaxSearchResponseBody.setMessage("No Todos Fond");
		} else {
			
			ajaxSearchResponseBody.setMessage("success");
		}
		
		ajaxSearchResponseBody.setTodosList(todosList);
		
		return ResponseEntity.ok(ajaxSearchResponseBody);
	}
}

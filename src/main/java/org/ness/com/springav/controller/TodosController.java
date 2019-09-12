/**
 * 
 */
package org.ness.com.springav.controller;

import org.ness.com.springav.model.Todos;
import org.ness.com.springav.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author P7108899
 *
 */
@Controller
public class TodosController {

	@Autowired
	private TodosRepository repository;
	
	@Value("${todos.delete.message:test}")
	private String todosDeleteMessage;
	
	
	// not in use
	@Value("${todos.not.found.message}")
	private String todosNotFoundMessage;
		
	@GetMapping("/todos-list")
	public ModelAndView showTodosHome() {
		
		return new ModelAndView("Todos", "todosList", repository.findAll());
	}
	
	@GetMapping("/add-todos-home")
	public ModelAndView showAddTodosHome() {
		
		// write code here
		return new ModelAndView("TodosAdd", "todos", new Todos());
	}
	
	// not working properly
	@PostMapping("/add-todo-by-form")
	public ModelAndView addTodo(@ModelAttribute Todos todo) {
		
		System.out.println(todo.getId() + "-" + todo.getStatus() + "-" + todo.getDescription() + "-" + todo.getDate());
		
		repository.save(todo);
		
		return showTodosHome();
	}
	public String editTodo() {
		
		
		// write code here
		return "";
	}
	
	@PostMapping(value = "/delete-todo", headers = "Accept=*/*")
	public ModelAndView deleteTodo(@RequestParam("id") int id, ModelMap modelMap) {
		
		repository.deleteTodoDetailsById(Long.valueOf(id));

		return new ModelAndView("TodosDeleted", "message", todosDeleteMessage);
	}
	
	@GetMapping("/todos-search")
	public ModelAndView todosSearchHome() {
		
		// write code here
		return new ModelAndView("TodosSearchViaAjax");	
	}
	
	@GetMapping(value = "/to-check-error-page/{isError}")
	public @ResponseBody ModelAndView oneFaultyMethod(@PathVariable("isError") boolean value) {
		
		if(value)
			throw new NullPointerException("This error message is for demo only");
		
		return null;
	}

	/*
	@ExceptionHandler({NullPointerException.class, ArrayIndexOutOfBoundsException.class, IOException.class})
	public ModelAndView handleException(NullPointerException nx) {

		// write code here
		return new ModelAndView("error", "message", nx.getMessage());
	}
	*/
}

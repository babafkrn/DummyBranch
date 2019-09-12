/**
 * 
 */
package org.ness.com.springav.controller;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.ness.com.springav.exceptions.TodosNotFoundException;
import org.ness.com.springav.model.Todos;
import org.ness.com.springav.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author P7108899
 *
 */
@RestController
public class TodosRestController {

	@Value("${my.secret}")
	private String mySecret;
	
	@Value("${my.number}")
	private int myNumber;
	
	@Value("${my.bignumber}")
	private Long myBigNumber;
	
	@Value("${my.uuid}")
	private String uuid;
	
	@Value("${my.number.less.than.ten}")
	private int lessThan;
	
	@Value("${my.number.in.range}")
	private int rangeNo;
	
	@Autowired
	private TodosRepository todosRepository;
	
	@GetMapping("/display-values")
	public String displayValues() {
		
		return "mySecret=" + mySecret + ", myNumber=" + myNumber + ", myBigNumber=" + myBigNumber + ", uuid=" + uuid + ", lessThan=" + lessThan + ",rangeNo=" + rangeNo;
	}
	
	@GetMapping("/all-todos")
	public List<Todos> getTodosList() {
		
		return todosRepository.findAll();
	}
	
	@PostMapping("/add-todo")
	public ResponseEntity<Object> addTodo(@RequestBody Todos todos) {
		
		Todos savedTodo = todosRepository.save(todos);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTodo.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("todos/{id}")
	public Todos getTodoById(@PathVariable Long id) {
		
		Optional<Todos> todo = todosRepository.findById(id);
		
		if(!todo.isPresent())
			throw new TodosNotFoundException("id-" + id);
		
		return todo.get();
	}
	
	@DeleteMapping("todos/{id}")
	public void deleteTodoById(@PathVariable Long id) {
		
		todosRepository.deleteById(id);
	}
	
	@PutMapping("edit-todo/{id}")
	public ResponseEntity<Object> updateTodo(@RequestBody Todos updatedtodo, @PathVariable Long id) {
		
		Optional<Todos> todo = todosRepository.findById(id);
		
		if(!todo.isPresent()) 
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/find-todos-by-status/{status}")
	public List<Todos> findTodosByStatus(@PathVariable String status) {
		
		return todosRepository.findByStatus(status);
	}
	
	@GetMapping("/find-todos-by-id/{id}")
	public Todos findTodosById(@PathVariable Long id) {
		
		return todosRepository.findById(id).get();
	}
	
	@GetMapping("/find-todos-by-description/{description}")
	public List<Todos> findTodosByDescription(String description) {
		
		return todosRepository.findByDescription(description);
	}

	@GetMapping("/find-todos-by-description-and-status/{description}/{status}")
	public List<Todos> findTodosByDescriptionAndStatus(String description, String status) {
		
		return todosRepository.findByDescriptionAndStatus(description, status);
	}
	
	@GetMapping("/find-todos-by-status-and-description/{status}/{description}")
	public List<Todos> findTodosByStatusAndDescription(String status, String description) {
		
		return todosRepository.findByStatusAndDescription(status, description);
	}
	
	@GetMapping("/find-todos-by-id-status-description/{id}/{status}/{description}")
	public List<Todos> findTodosByIdAndStatusAndDescription(Long id, String status, String description) {
		
		return todosRepository.findByIdAndStatusAndDescription(id , status, description);
	}
	
	@GetMapping("/find-todos-by-status-description-id/{status}/{description}/{id}")
	public List<Todos> findTodosByStatusAndDescriptionAndId(String status, String description, Long id) {
		
		return todosRepository.findByStatusAndDescriptionAndId(status, description, id);
	}
	
	@GetMapping("/find-todos-by-description-id-status/{description}/{id}/{status}")
	public List<Todos> findByDescriptionAndIdAndStatus(String description, Long id, String status) {
		
		return todosRepository.findByDescriptionAndIdAndStatus(description, id, status);
	}
	
	@GetMapping("/find-todos-by-id-description-status/{id}/{description}/{status}")
	public List<Todos> findTodosByIdAndDescriptionAndStatus(Long id, String description, String status) {
		
		return todosRepository.findByIdAndDescriptionAndStatus(id, description, status);
	}
	
	@GetMapping("/find-todos-by-status-or-description/{status}/{description}")
	public List<Todos> findByStatusOrDescription(@PathVariable String status, @PathVariable String description) {
		
		return todosRepository.findByStatusOrDescription(status, description);
	}
	
	// find by id less than
	@GetMapping("/find-todos-by-id-less-than/{id}")
	public List<Todos> findByIdLessThan(@PathVariable Long id) {
		
		return todosRepository.findByIdLessThan(id);
	}
	
	// find by id less than or equal to
	@GetMapping("/find-todos-by-id-less-than-equal-to/{id}")
	public List<Todos> findByIdLessThanEqual(@PathVariable Long id) {
		
		return todosRepository.findByIdLessThanEqual(id);
	}

	// find by id greater than
	@GetMapping("/find-todos-by-id-greater-than/{id}")
	public List<Todos> findByIdGreaterThan(@PathVariable Long id) {
		
		return todosRepository.findByIdGreaterThan(id);	
	}
		
	// find by id greater than or equal to
	@GetMapping("/find-todos-by-id-greater-than-equal-to/{id}")
	public List<Todos> findByIdGreaterThanEqual(@PathVariable Long id) {
		
		return todosRepository.findByIdGreaterThanEqual(id);
	}
	
	// find by description which are null
	@GetMapping("/find-todos-by-description-as-null")
	public List<Todos> findTodosByDescriptionIsNull() {
		
		return todosRepository.findByDescriptionIsNull();
	}
	
	// find by descriptions which are not null
	@GetMapping("/find-todos-by-description-is-not-null")
	public List<Todos> findTodosByDescriptionIsNotNull() {
		
		return todosRepository.findByDescriptionIsNotNull();
	}
		
	// find by descriptions which are not null
	@GetMapping("/find-todos-by-description-as-not-null")
	public List<Todos> findTodosByDescriptionNotNull() {
		
		return todosRepository.findByDescriptionNotNull();
	}
	
	// find by descriptions name containing
	@GetMapping("/find-todos-by-description-contain/{description}")
	public List<Todos> findTodosByDescriptionContaining(@PathVariable("description") String description) {
		
		return todosRepository.findByDescriptionContaining(description);
	}
	
	// find by status not like
	@GetMapping("/find-todos-by-status-not-like/{status}")
	public List<Todos> findTodosByStatusNotLike(@PathVariable("status")String status) {
		
		return todosRepository.findByStatusNotLike(status);
	}
	
	// find by description equals
	@GetMapping("/find-todos-by-description-equals/{description}")
	public Todos findByDescriptionEquals(@PathVariable("description") String description) {
	
		return todosRepository.findByDescriptionEquals(description).get();
	}
	
	// find by description equals ignore case
	@GetMapping("/find-todos-by-description-ignore-case/{description}")
	public Todos findByDescriptionIgnoreCase(@PathVariable("description") String description) {
	
		return todosRepository.findByDescriptionIgnoreCase(description).get();
	}
	
	// find by status and order by description desc
	@GetMapping("/find-todos-by-status-in-sorting-order/{status}")
	public List<Todos> findTodosByStatusOrderByDescriptionDesc(@PathVariable("status") String status) {
		
		return todosRepository.findByStatusOrderByDescriptionDesc(status);
	}
	
	// find todos by status
	@GetMapping("/find-todos-list-by-status/{status}")
	public List<Todos> findTodosListByStatus(@PathVariable("status") String status) {
		
		return todosRepository.findTodosByStatus(status);
	}
	
	@GetMapping("/find-todos-by-status-id-desc/{status}/{id}/{description}")
	public Todos findTodoByStatusAndIdAndDescription(@PathVariable("status") String status, @PathVariable("id") Long id, 
			@PathVariable("description") String description) {
		
		return todosRepository.findTodoByStatusAndIdAndDescription(status, id, description);
	}
	
	@GetMapping("/update-todo-by-id/{id}/{description}")
	public Todos updateTodoDetailsById(@PathVariable("id") Long id,@PathVariable("description") String description) {
		
		// update
		todosRepository.updateTodoDetailsById(id, description);
		
		// fetch
		return todosRepository.findById(id).get();
	}
	
	@GetMapping("/delete-todo-by-id/{id}")
	public String deleteTodoDetailsById(@PathVariable("id") Long id) {
		
		return "Todo deleted" + todosRepository.deleteTodoDetailsById(id);
	}
	
	// not working
	@GetMapping("/find-todos-between/{date1}/{date2}")
	public List<Todos> findTodosByDateBetween(@PathVariable String date1, @PathVariable String date2) {
		
		System.out.println("date1: "+ date1 + " " + "date2: " + date2);
		
		List<Todos> todosList = null;
		try {
		
			Date parsedDate1 = new SimpleDateFormat("dd/MM/yyyy").parse(date1);
			Date parsedDate2 = new SimpleDateFormat("dd/MM/yyyy").parse(date2);
			
			System.out.println("date1: "+ parsedDate1 + " " + "date2: " + parsedDate2);
			
			todosList = todosRepository.findByDateBetween(parsedDate1, parsedDate2);
			
		} catch (ParseException pEx) {
			System.out.println("ParseException occured in findTodosByDateBetween()" + pEx);
		}
		return todosList;
	}
}

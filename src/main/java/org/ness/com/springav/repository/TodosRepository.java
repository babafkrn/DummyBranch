/**
 * 
 */
package org.ness.com.springav.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.ness.com.springav.model.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author P7108899
 *
 */
@Repository
public interface TodosRepository extends JpaRepository<Todos, Long> {

	public Optional<Todos> findById(Long id);
	
	public List<Todos> findByStatus(String status);
	
	public List<Todos> findByDescription(String description);
	
	public List<Todos> findByDescriptionAndStatus(String description, String status);
	
	public List<Todos> findByStatusAndDescription(String status, String description);
	
	public List<Todos> findByIdAndStatusAndDescription(Long id, String status, String description);
	
	public List<Todos> findByStatusAndDescriptionAndId(String status, String description, Long id);
	
	public List<Todos> findByDescriptionAndIdAndStatus(String description, Long id, String status);
	
	public List<Todos> findByIdAndDescriptionAndStatus(Long id, String description, String status);
	
	// find by status or description
	public List<Todos> findByStatusOrDescription(String status, String description);
	
	// find by id less than
	public List<Todos> findByIdLessThan(Long id);
	
	// find by id greater than
	public List<Todos> findByIdGreaterThan(Long id);
	
	// find by id less than or equal to
	public List<Todos> findByIdLessThanEqual(Long id);
	
	// find by id greater than or equal to
	public List<Todos> findByIdGreaterThanEqual(Long id);
	
	// find by target date between
	public List<Todos> findByDateBetween(Date date1, Date date2);
	
	// find by description which are null
	public List<Todos> findByDescriptionIsNull();
	
	// find by descriptions which are not null
	public List<Todos> findByDescriptionIsNotNull();
	
	// find by descriptions which are not null
	public List<Todos> findByDescriptionNotNull();

	// find by descriptions name containing
	public List<Todos> findByDescriptionContaining(String name);
	
	// find by status not like
	public List<Todos> findByStatusNotLike(String status);
	
	// find by description equals
	public Optional<Todos> findByDescriptionEquals(String description);
	
	// find by description equals ignore case
	public Optional<Todos> findByDescriptionIgnoreCase(String description);
	
	// find by status and order by description desc
	public List<Todos> findByStatusOrderByDescriptionDesc(String status);
	
	// find todos by status
	public List<Todos> findTodosByStatus(String name);
	
	// find todos by status, description and id
	public Todos findTodoByStatusAndIdAndDescription(String status, Long id, String description);
	
	@Transactional
	@Modifying
	@Query("update Todos t set t.description=?2 where t.id=?1")
	public int updateTodoDetailsById(Long id, String description);
	
	@Transactional
	@Modifying
	@Query("delete from Todos t where t.id=?1")
	public int deleteTodoDetailsById(Long id);
	
	}
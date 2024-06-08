package TaskManagement2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import TaskManagement2.entitities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	List<Task> findByStatusAndPriority(String status, String priority);
    List<Task> findByStatus(String status);
    List<Task> findByPriority(String priority);

}

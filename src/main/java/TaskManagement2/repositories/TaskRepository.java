package TaskManagement2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import TaskManagement2.entitities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	

}

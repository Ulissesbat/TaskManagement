package TaskManagement2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import TaskManagement2.dto.TaskDTO;
import TaskManagement2.entitities.Task;
import TaskManagement2.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repository;

	@Transactional
	public TaskDTO insert(TaskDTO dto) {

		Task entity = new Task();
		setTaskProperties(entity, dto);
		entity = repository.save(entity);
		return new TaskDTO(entity);

	}

	@Transactional(readOnly = true)
	public Page<TaskDTO> findAll(Pageable pageable) {
		Page<Task> result = repository.findAll(pageable);
		return result.map(x -> new TaskDTO(x));

	}

	@Transactional
	public TaskDTO update(Long id, TaskDTO dto) {
		Task entity = repository.getReferenceById(id);
		setTaskProperties(entity, dto);
		entity = repository.save(entity);
		return new TaskDTO(entity);
	}
	
	 private void setTaskProperties(Task entity, TaskDTO dto) {
		 
	        entity.setTitle(dto.getTitle());
	        entity.setDescription(dto.getDescription());
	        entity.setDueDate(dto.getDueDate());
	        entity.setPriority(dto.getPriority());
	        entity.setStatus(dto.getStatus());
	    }
}

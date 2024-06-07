package TaskManagement2.dto;

import java.time.LocalDateTime;

import TaskManagement2.entitities.Task;

public class TaskDTO {

	private Long id;
	private String title;
	private String description;
	private LocalDateTime creationDate;
	private LocalDateTime dueDate;
	private String priority;
	private String status;
	
	
	public TaskDTO(Long id, String title, String description, LocalDateTime creationDate, LocalDateTime dueDate,
			String priority, String status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.creationDate = creationDate;
		this.dueDate = dueDate;
		this.priority = priority;
		this.status = status;
	}
	
	public TaskDTO(Task entite) {

		id = entite.getId();
		title = entite.getTitle();
		description = entite.getDescription();
		creationDate = entite.getCreationDate();
		dueDate = entite.getDueDate();
		priority = entite.getPriority();
		status = entite.getStatus();
	}
	
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public String getPriority() {
		return priority;
	}
	public String getStatus() {
		return status;
	}
	
	

}

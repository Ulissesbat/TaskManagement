package TaskManagement2.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import TaskManagement2.dto.TaskDTO;
import TaskManagement2.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@PostMapping
	public ResponseEntity<TaskDTO> insert (@RequestBody TaskDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);	
	}
	@GetMapping
	public ResponseEntity<Page<TaskDTO>>findAll(Pageable pageable){
		Page<TaskDTO> dto = service.findAll(pageable);
		return ResponseEntity.ok(dto);
		
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<TaskDTO>update(@PathVariable Long id, @RequestBody TaskDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok(dto);
	}
}
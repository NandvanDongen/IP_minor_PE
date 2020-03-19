package ip_minor.project.service;

import ip_minor.project.domain.Task;
import ip_minor.project.dto.TaskDTO;

import ip_minor.project.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepo repository;

    @Autowired
    public TaskServiceImpl(TaskRepo repository){
        this.repository = repository;
    }

    @Override
    public List<TaskDTO> getTasks() {
        return repository.findAll().stream().map(t ->{
            TaskDTO dto = new TaskDTO();
            dto.setTitle(t.getTitle());
            dto.setDescription(t.getDescription());
            dto.setDueDate(t.getDueDate());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public Task getTask(Long id) {
        Task result = null;
        for (Task task:repository.findAll()) {
            if(task.getId() == id){
                result = task;
            }
        }
        return result;
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        repository.save(task);
    }
}

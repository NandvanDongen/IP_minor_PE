package ip_minor.project.service;

import ip_minor.project.domain.SubTask;
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
            dto.setId(t.getId());
            dto.setTitle(t.getTitle());
            dto.setDescription(t.getDescription());
            dto.setDueDate(t.getDueDate());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTask(Long id) {
        TaskDTO result = new TaskDTO();
        for (Task task:repository.findAll()) {
            if(task.getId() == id){
                result.setId(id);
                result.setTitle(task.getTitle());
                result.setDescription(task.getDescription());
                result.setDueDate(task.getDueDate());
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

    @Override
    public void editTask(Long id, TaskDTO taskDTO){
        for (Task task: repository.findAll()) {
            if(task.getId() == id){
                task.setTitle(taskDTO.getTitle());
                task.setDescription(taskDTO.getDescription());
                task.setDueDate(taskDTO.getDueDate());
                repository.save(task);
            }
        }
    }

    @Override
    public void addSubTask(Long id, SubTask subTask){
        for (Task task: repository.findAll()) {
            if(task.getId() == id){
                task.addSubTask(subTask);
                repository.save(task);
            }
        }
    }
}

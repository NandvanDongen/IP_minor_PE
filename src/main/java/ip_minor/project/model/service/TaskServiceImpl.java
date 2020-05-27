package ip_minor.project.model.service;

import ip_minor.project.model.dto.SubTaskDTO;
import ip_minor.project.model.dto.TaskDTO;
import ip_minor.project.model.entity.SubTask;
import ip_minor.project.model.entity.Task;
import ip_minor.project.model.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private final TaskRepo repository;

    @Autowired
    public TaskServiceImpl(TaskRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<TaskDTO> getTasks() {
        return repository.findAll().stream().map(t -> {
            TaskDTO dto = new TaskDTO();
            dto.setId(t.getId());
            dto.setTitle(t.getTitle());
            dto.setDescription(t.getDescription());
            dto.setDueDate(t.getDueDate());
            dto.setSubtasks(t.getSubtasks());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTask(Long id) {
        TaskDTO result = new TaskDTO();
        for (Task task : repository.findAll()) {
            if (task.getId() == id) {
                result.setId(id);
                result.setTitle(task.getTitle());
                result.setDescription(task.getDescription());
                result.setDueDate(task.getDueDate());
                result.setSubtasks(task.getSubtasks());
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
        task.setSubtasks(new ArrayList<SubTask>());
        repository.save(task);
    }

    @Override
    public void editTask(Long id, TaskDTO taskDTO) {
        for (Task task : repository.findAll()) {
            if (task.getId() == id) {
                task.setTitle(taskDTO.getTitle());
                task.setDescription(taskDTO.getDescription());
                task.setDueDate(taskDTO.getDueDate());
                task.setSubtasks(taskDTO.getSubtasks());
                repository.save(task);
            }
        }
    }

    @Override
    public void addSubTask(Long id, SubTaskDTO subTaskDTO) {
        for (Task task : repository.findAll()) {
            if (task.getId() == id) {
                task.addSubTask(subTaskDTO);
                repository.save(task);
            }
        }
    }

    public void deleteTasks() {
        repository.deleteAll();
    }

    public void deleteTask(Long id) {
        for (Task task : repository.findAll()) {
            if (task.getId() == id) {
                repository.delete(task);
            }
        }
    }
}

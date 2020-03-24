package ip_minor.project.service;

import ip_minor.project.domain.Task;
import ip_minor.project.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getTasks();

    Task getTask(Long id);

    void addTask(TaskDTO task);

    void editTask(Long id, TaskDTO taskDTO);
}

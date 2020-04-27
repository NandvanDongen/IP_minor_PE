package ip_minor.project.service;

import ip_minor.project.domain.SubTask;
import ip_minor.project.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getTasks();

    TaskDTO getTask(Long id);

    void addTask(TaskDTO task);

    void editTask(Long id, TaskDTO taskDTO);

    void addSubTask(Long id, SubTask subTask);
}

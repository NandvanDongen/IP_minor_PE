package ip_minor.project.model.service;

import ip_minor.project.model.dto.SubTaskDTO;
import ip_minor.project.model.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getTasks();

    TaskDTO getTask(Long id);

    void addTask(TaskDTO task);

    void editTask(Long id, TaskDTO taskDTO);

    void addSubTask(Long id, SubTaskDTO subTaskDTO);
}

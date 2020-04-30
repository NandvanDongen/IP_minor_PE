package ip_minor.project.domain;

import ip_minor.project.dto.SubTaskDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String title;
    private String description;
    private LocalDateTime dueDate;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SubTask> subtasks;

    public Task() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public List<SubTask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<SubTask> subtasks) {
        this.subtasks = subtasks;
    }

    public void addSubTask(SubTask subTask) {
        this.subtasks.add(subTask);
    }

    public void removeSubTask(SubTask subTask) {
        this.subtasks.remove(subTask);
    }

    public void addSubTask(SubTaskDTO subTaskDTO){
        SubTask subTask = new SubTask();
        subTask.setTitle(subTaskDTO.getTitle());
        subTask.setDescription(subTaskDTO.getDescription());
        subtasks.add(subTask);
    }
}

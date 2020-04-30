package ip_minor.project.dto;

import ip_minor.project.domain.Task;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class SubTaskDTO {
    private Long id;
    @NotNull
    private String title;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private Task task;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

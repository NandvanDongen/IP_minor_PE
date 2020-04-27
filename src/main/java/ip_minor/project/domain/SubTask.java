package ip_minor.project.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class SubTask {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String title;
    private String description;
    @ManyToOne
    private Task task;

    public SubTask() {

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

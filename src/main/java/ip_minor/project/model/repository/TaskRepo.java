package ip_minor.project.model.repository;

import ip_minor.project.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
}

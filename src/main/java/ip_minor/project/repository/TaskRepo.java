package ip_minor.project.repository;

import ip_minor.project.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepo extends JpaRepository<Task, Long> {
}

package ip_minor.project.model.repository;

import ip_minor.project.model.entity.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepo extends JpaRepository<SubTask, Long> {
}

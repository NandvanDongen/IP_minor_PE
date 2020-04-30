package ip_minor.project.repository;

import ip_minor.project.domain.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepo extends JpaRepository<SubTask, Long> {
}

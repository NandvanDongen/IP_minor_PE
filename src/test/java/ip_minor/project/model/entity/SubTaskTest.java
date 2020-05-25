package ip_minor.project.model.entity;

import ip_minor.project.model.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SubTaskTest {
	private TaskService taskService;

	@Test
	public void testSetTitle() {
		// setup
		SubTask task = new SubTask();

		// method to be tested
		task.setTitle("title");

		// checks
		assertEquals("title", task.getTitle());
}
	@Test
	public void testSetDescription() {
		// setup
		SubTask task = new SubTask();

		// method to be tested
		task.setDescription("description");

		// checks
		assertEquals("description",task.getDescription());
	}
}

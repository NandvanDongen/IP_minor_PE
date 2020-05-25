package ip_minor.project.model.DTO;

import ip_minor.project.model.entity.SubTask;
import ip_minor.project.model.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SubTaskDTOTest {
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
	public void testGetTitle() {
		// setup
		SubTask task = new SubTask();
		task.setTitle("title");

		// method to be tested
		String title = task.getTitle();

		// checks
		assertEquals("title", title);
	}

    @Test
    public void testSetDescription() {
        // setup
        SubTask task = new SubTask();

        // method to be tested
        task.setDescription("description");

        // checks
        assertEquals("description", task.getDescription());
    }

    @Test
    public void testGetDescription() {
        // setup
        SubTask task = new SubTask();
        task.setDescription("description");

        // method to be tested
        String desc = task.getDescription();

        // checks
        assertEquals("description", desc);
    }
}

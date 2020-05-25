package ip_minor.project.model.DTO;

import ip_minor.project.model.entity.SubTask;
import ip_minor.project.model.entity.Task;
import ip_minor.project.model.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskDTOTest {
    private TaskService taskService;

    @Test
    public void testSetTitle() {
        // setup
        Task task = new Task();

        // method to be tested
        task.setTitle("title");

        // checks
        assertEquals("title", task.getTitle());
    }

    @Test
    public void testGetTitle() {
        // setup
        Task task = new Task();
        task.setTitle("title");

        // method to be tested
        String title = task.getTitle();

        // checks
        assertEquals("title", title);
    }

    @Test
    public void testSetDescription() {
        // setup
        Task task = new Task();

        // method to be tested
        task.setDescription("description");

        // checks
        assertEquals("description", task.getDescription());
    }

    @Test
    public void testGetDescription() {
        // setup
        Task task = new Task();
        task.setDescription("description");

        // method to be tested
        String desc = task.getDescription();

        // checks
        assertEquals("description", desc);
    }

    @Test
    public void testSetDueDate() {
        // setup
        Task task = new Task();

        // method to be tested
        task.setDueDate(LocalDateTime.of(2020, 05, 05, 20, 20));

        // checks
        assertEquals(LocalDateTime.of(2020, 05, 05, 20, 20), task.getDueDate());
    }

    @Test
    public void testGetDueDate() {
        // setup
        Task task = new Task();
        task.setDueDate(LocalDateTime.of(2020, 05, 05, 20, 20));

        // method to be tested
        LocalDateTime dueDate = task.getDueDate();

        // checks
        assertEquals(LocalDateTime.of(2020, 05, 05, 20, 20), dueDate);
    }

    @Test
    public void testSetSubTasks() {
        // setup
        Task task = new Task();
        List<SubTask> subTasks = new ArrayList<SubTask>();
        SubTask subTask = new SubTask();
        subTask.setTitle("title");
        subTask.setDescription("description");
        subTasks.add(subTask);

        // method to be tested
        task.setSubtasks(subTasks);

        // checks
        assertNotNull(task.getSubtasks());
        assertFalse(task.getSubtasks().size() == 0);
        assertEquals(subTask, task.getSubtasks().get(0));
    }

	@Test
	public void testGetSubTasks() {
		// setup
		Task task = new Task();
		List<SubTask> subTasks = new ArrayList<SubTask>();
		SubTask subTask = new SubTask();
		subTask.setTitle("title");
		subTask.setDescription("description");
		subTasks.add(subTask);
		task.setSubtasks(subTasks);

		// method to be tested
		List<SubTask> subtasks = task.getSubtasks();;

		// checks
		assertNotNull(subtasks);
		assertFalse(subtasks.size() == 0);
		assertEquals(subTask, subtasks.get(0));
	}

    @Test
    public void testAddSubTask() {
        // setup
        // setup
        Task task = new Task();
        List<SubTask> subTasks = new ArrayList<SubTask>();
        SubTask subTask = new SubTask();
        subTask.setTitle("title");
        subTask.setDescription("description");
        subTasks.add(subTask);

        // method to be tested
        task.setSubtasks(subTasks);

        // checks
        assertNotNull(task.getSubtasks());
        assertFalse(task.getSubtasks().size() == 0);
        assertEquals(subTask, task.getSubtasks().get(0));
        assertEquals("title", task.getSubtasks().get(0).getTitle());
        assertEquals("description", task.getSubtasks().get(0).getDescription());
    }
}

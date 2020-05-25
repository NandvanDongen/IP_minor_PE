package ip_minor.project.model.service;

import ip_minor.project.model.dto.TaskDTO;
import ip_minor.project.model.entity.SubTask;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TaskServiceImplTest {
	@Autowired
	private TaskServiceImpl taskService;

	@BeforeEach
	public void setUpTaskDTO(){
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setTitle("title");
		taskDTO.setDescription("description");
		taskDTO.setDueDate(LocalDateTime.of(2020, 03, 10, 10, 0));
		taskDTO.setSubtasks(new ArrayList<SubTask>());
		taskService.addTask(taskDTO);
	}

	@AfterEach
	public void cleanUp(){
		taskService.deleteTasks();
	}

	@Test
	public void testGetTasks() {
		// setup see @BeforeEach

		// method to be tested
		List<TaskDTO> tasks = taskService.getTasks();

		// checks
		assertNotNull(tasks);
		assertFalse(tasks.isEmpty());
		assertEquals(1, tasks.size());
		TaskDTO task = tasks.get(0);
		assertNotNull(task);
		assertEquals("title",task.getTitle());
		assertEquals("description",task.getDescription());
	}

	@Test
	public void testGetTask() {
		// setup see @BeforeEach

		// method to be tested
		TaskDTO task = taskService.getTask((long) 5);

		// checks
		assertNotNull(task);
		assertEquals( "title",task.getTitle());
		assertEquals("description",task.getDescription());
	}

	@Test
	public void testAddTask() {
		// setup see @BeforeEach

		// method to be tested addTask (done in setup)

		// checks
		TaskDTO task = taskService.getTask((long) 4);
		assertNotNull(task);
		assertEquals("title", task.getTitle());
		assertEquals("description",task.getDescription() );
		assertEquals(LocalDateTime.of(2020, 03, 10, 10, 0),task.getDueDate());
	}

	@Test
	public void testEditTask() {
		// setup see @BeforeEach +
		//to edit
		TaskDTO taskDTOEdit = new TaskDTO();
		taskDTOEdit.setTitle("editedtitle");
		taskDTOEdit.setDescription("editeddescription");
		taskDTOEdit.setDueDate(LocalDateTime.of(2021, 05, 20, 20, 50));

		// method to be tested
		taskService.editTask((long) 2,taskDTOEdit);

		// checks
		TaskDTO task = taskService.getTask((long) 2);
		assertNotNull(task);
		assertEquals("editedtitle",task.getTitle() );
		assertEquals("editeddescription",task.getDescription());
		assertEquals(LocalDateTime.of(2021, 05, 20, 20, 50),task.getDueDate());
	}
}

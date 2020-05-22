/*package ip_minor.project.service;

import ip_minor.project.model.entity.SubTask;
import ip_minor.project.model.dto.SubTaskDTO;
import ip_minor.project.model.dto.TaskDTO;
import ip_minor.project.model.repository.TaskRepo;
import org.hibernate.cfg.annotations.reflection.JPAMetadataProvider;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TaskServiceImplTest {
	@Mock
	private final TaskRepo taskRepo = ;

	@Autowired
	private TaskServiceImpl taskService = new TaskServiceImpl(taskRepo);



	@Test
	public void testGetTasks() {
		// setup
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setTitle("title");
		taskDTO.setDescription("description");
		taskDTO.setDueDate(LocalDateTime.of(2020, 03, 10, 10, 0));
		taskService.addTask(taskDTO);

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
		// setup
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setTitle("title");
		taskDTO.setDescription("description");
		taskDTO.setDueDate(LocalDateTime.of(2020, 03, 10, 10, 0));
		taskService.addTask(taskDTO);

		// method to be tested
		TaskDTO task = taskService.getTask(Long.parseLong("1"));

		// checks
		assertNotNull(task);
		assertEquals( "title",task.getTitle());
		assertEquals("description",task.getDescription());
	}

	@Test
	public void testAddTask() {
		// setup
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setTitle("title");
		taskDTO.setDescription("description");
		taskDTO.setDueDate(LocalDateTime.of(2020, 03, 10, 10, 0));
		taskService.addTask(taskDTO);

		// method to be tested
		taskService.addTask(taskDTO);

		// checks
		TaskDTO task = taskService.getTasks().get(0);
		assertNotNull(task);
		assertEquals("title", task.getTitle());
		assertEquals("description",task.getDescription() );
		assertEquals(LocalDateTime.of(2020, 03, 10, 10, 0),task.getDueDate());
	}

	@Test
	public void testEditTask() {
		// setup
		//add task
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setTitle("title");
		taskDTO.setDescription("description");
		taskDTO.setDueDate(LocalDateTime.of(2020, 03, 10, 10, 0));
		taskService.addTask(taskDTO);
		//to edit
		TaskDTO taskDTO1 = new TaskDTO();
		taskDTO1.setTitle("editedtitle");
		taskDTO1.setDescription("editeddescription");
		taskDTO1.setDueDate(LocalDateTime.of(2021, 05, 20, 20, 50));

		// method to be tested
		taskService.editTask(Long.parseLong("1"),taskDTO1);

		// checks
		TaskDTO task = taskService.getTasks().get(0);
		assertNotNull(task);
		assertEquals("title",task.getTitle() );
		assertEquals("description",task.getDescription());
		assertEquals(LocalDateTime.of(2021, 05, 20, 20, 50),task.getDueDate());
	}

	@Test
	public void testAddSubTask() {
		// setup
		//add task
		TaskDTO taskDTO = new TaskDTO();
		taskDTO.setTitle("title");
		taskDTO.setDescription("description");
		taskDTO.setDueDate(LocalDateTime.of(2020, 03, 10, 10, 0));
		taskService.addTask(taskDTO);
		//to edit
		SubTaskDTO subtask = new SubTaskDTO();
		subtask.setTitle("editedtitle");
		subtask.setDescription("editeddescription");

		// method to be tested
		taskService.addSubTask(Long.parseLong("1"),subtask);

		// checks
		SubTask subTask = taskService.getTasks().get(0).getSubtasks().get(0);
		assertNotNull(subTask);
		assertEquals("title",subTask.getTitle());
		assertEquals("description",subTask.getDescription());
	}

}*/

package ip_minor.project.model.entity;

import ip_minor.project.model.dto.SubTaskDTO;
import ip_minor.project.model.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskTest {
    private TaskService taskService;

    @Test
    public void testSetTitle() {
        // setup
        Task task = new Task();

        // method to be tested
        task.setTitle("title");

        // checks
        assertNotNull(task.getTitle());
        assertEquals("title", task.getTitle());
    }

    @Test
    public void testSetDescription() {
        // setup
        Task task = new Task();

        // method to be tested
        task.setDescription("description");

        // checks
        assertNotNull(task.getDescription());
        assertEquals("description", task.getDescription());
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
    public void testAddSubTask() {
        // setup
        Task task = new Task();
        task.setTitle("title");
        task.setDescription("desc");
        task.setDueDate(LocalDateTime.of(2020, 05, 05, 20, 20));
        task.setSubtasks(new ArrayList<SubTask>());
        SubTaskDTO subTask = new SubTaskDTO();
        subTask.setTitle("subtitle");
        subTask.setDescription("subdesc");

        // method to be tested
        task.addSubTask(subTask);

        // checks
        assertFalse(task.getSubtasks().size() == 0);
        assertNotNull(task.getSubtasks().get(0));
        assertEquals("subtitle", task.getSubtasks().get(0).getTitle());
        assertEquals("subdesc", task.getSubtasks().get(0).getDescription());
    }

    @Test
    public void testTask() {
        //setup

        //method to be tested
        Task task = new Task("title", "description", LocalDateTime.of(2020, 05, 05, 20, 20));

        //checks
        assertEquals("title", task.getTitle());
        assertEquals("description", task.getDescription());
        assertEquals(LocalDateTime.of(2020, 05, 05, 20, 20), task.getDueDate());
    }
}

package ip_minor.project.controller;

import ip_minor.project.model.entity.SubTask;
import ip_minor.project.model.entity.Task;
import ip_minor.project.model.dto.SubTaskDTO;
import ip_minor.project.model.dto.TaskDTO;
import ip_minor.project.model.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class TaskManagerController {
    @Autowired
    private TaskService taskService;

    @GetMapping()
    public String getIndex() {
        return "index";
    }

    @GetMapping("/accessdenied")
    public String getDenied() {
        return "accessdenied";
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "taskOverview";
    }

    @GetMapping("/tasks/new")
    public String getCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "addTask";
    }

    @GetMapping("/tasks/{id}")
    public String getTaskDetail(@PathVariable("id") Long id, Model model) {
        List<String> errors = new ArrayList<String>();
        if (taskService.getTask(id).getId() != id) {
            model.addAttribute("task", null);
            return "taskDetails";
        }
        model.addAttribute("task", taskService.getTask(id));
        return "taskDetails";
    }

    @GetMapping("/tasks/edit/{id}")
    public String editTask(@PathVariable("id") Long id, Model model) {
        if (taskService.getTask(id).getId() != id) {
            model.addAttribute("task", null);
            return "taskDetails";
        }
        model.addAttribute("task", taskService.getTask(id));
        return "editTask";
    }

    @GetMapping("/tasks/{id}/sub/create")
    public String getSubtaskForm(@PathVariable("id") Long id, Model model) {
        if (taskService.getTask(id).getId() != id) {
            model.addAttribute("mastertask", null);
            return "addSubtask";
        }
        SubTask subTask = new SubTask();
        model.addAttribute("subtask", subTask);
        model.addAttribute("mastertask", taskService.getTask(id));
        return "addSubtask";
    }

    @PostMapping("/tasks/new")
    public String addtask(@ModelAttribute("task") @Valid TaskDTO task, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addTask";
        }
        if (task.getDueDate() == null){
            return "addTask";
        }
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    @PostMapping("/tasks/edit")
    public String edit(@ModelAttribute("task") @Valid TaskDTO task, BindingResult bindingResult) {
        Long id = task.getId();
        if (bindingResult.hasErrors()) {
            return "editTask";
        }
        if (task.getDueDate() == null){
            return "addTask";
        }
        taskService.editTask(id, task);
        return "redirect:/tasks/" + task.getId();
    }

    @PostMapping("/tasks/sub/create")
    public String addSubtask(@ModelAttribute("subtask") @Valid SubTaskDTO subTaskDTO, BindingResult bindingResult, @RequestParam(value = "masterTaskId") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("mastertask", taskService.getTask(id));
            return "addSubtask";
        }
        taskService.addSubTask(id, subTaskDTO);
        return "redirect:/tasks/" + id;
    }
}

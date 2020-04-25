package ip_minor.project.controller;

import ip_minor.project.domain.Task;
import ip_minor.project.dto.TaskDTO;
import ip_minor.project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping()
public class TaskManagerController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String getIndex() {
        return "index";
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
        Task result = taskService.getTask(id);
        model.addAttribute("task", result);
        return "taskDetails";
    }

    @GetMapping("/tasks/edit/{id}")
    public String editTask(@PathVariable("id") Long id, Model model) {
        Task result = taskService.getTask(id);
        model.addAttribute("task", result);
        model.addAttribute("id", id);
        return "editTask";
    }

    @GetMapping("/tasks/{id}/sub/create")
    public String getSubtaskForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("parent", taskService.getTask(id));
        return "addSubtask";
    }

    @PostMapping("/tasks/new")
    public String addtask(@ModelAttribute @Valid TaskDTO task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addTask";
        }
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    @PostMapping("/tasks/edit/{id}")
    public String edit(@ModelAttribute @Valid TaskDTO task, @PathVariable("id") Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editTask";
        }
        taskService.editTask(id, task);
        return "redirect:/{id}";
    }

    @PostMapping("/tasks/{id}/sub/create")
    public String addSubtask() {
        return "taskDetails";
    }
}

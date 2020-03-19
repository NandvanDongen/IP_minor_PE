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
@RequestMapping("/tasks")
public class TaskManagerController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getTask(Model model){
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("/new")
    public String getCreateForm(Model model){
        model.addAttribute("task", new Task());
        return "form";
    }

    @GetMapping("/{id}")
    public String getTaskDetail(@PathVariable("id") Long id, Model model){
        Task result = taskService.getTask(id);
        model.addAttribute("task",result);
        return "taskDetail";
    }

    @PostMapping
    public String addtask(@ModelAttribute @Valid TaskDTO taskDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "form";
        }
        taskService.addTask(taskDTO);
        return "redirect:/tasks";
    }


}

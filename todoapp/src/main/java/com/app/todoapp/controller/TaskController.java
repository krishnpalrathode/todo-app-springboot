package com.app.todoapp.controller;

import com.app.todoapp.models.Task;
import com.app.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskservice;

    public TaskController(TaskService taskservice){
        this.taskservice = taskservice;
    }
@GetMapping
    public String getTasks(Model model){
        List<Task> tasks =taskservice.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }
    @PostMapping
    public String createTask(@RequestParam String title){
       taskservice.createTask(title);
       return "redirect:/";

    }
    @GetMapping("/{id}/delete")
    public String deleteTasks(@PathVariable Long id){
        taskservice.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTasks(@PathVariable Long id){
        taskservice.toggleTask(id);
        return "redirect:/";
    }
}

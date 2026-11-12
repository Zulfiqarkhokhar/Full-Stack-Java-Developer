package com.example.SmartTodoApp.controller;

import com.example.SmartTodoApp.entity.Tasks;
import com.example.SmartTodoApp.service.TasksService;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TasksController {

    private TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping
    public ResponseEntity<List<Tasks>> getAllTasks() {
        List<Tasks> tasks = tasksService.getAllTasks();

        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveTask(@RequestBody Tasks task) {
        tasksService.saveTask(task);
        return ResponseEntity.ok("Task saved successfully");
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

}

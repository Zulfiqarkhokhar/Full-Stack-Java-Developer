package com.example.SmartTodoApp.service;

import com.example.SmartTodoApp.entity.Tasks;
import com.example.SmartTodoApp.repository.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {

    private TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public void saveTask(Tasks tasks) {
        tasksRepository.save(tasks);
    }

    public List<Tasks> getAllTasks() {

        return tasksRepository.findAll();
    }
}

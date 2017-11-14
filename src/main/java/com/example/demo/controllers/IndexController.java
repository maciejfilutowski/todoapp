package com.example.demo.controllers;

import com.example.demo.model.Project;
import com.example.demo.model.Task;
import com.example.demo.repositories.ProjectRepository;
import com.example.demo.repositories.TaskRepository;
import com.example.demo.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.Set;

/**
 * Created by filutma1 on 2017-11-14.
 */
@Controller
public class IndexController {

    private final TaskService taskService;

    public IndexController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage() {

        Set<Task> tasks = taskService.getAllTasks();

        for (Task task : tasks) {
            System.out.println(task.getTaskName());
        }

        return "index";
    }
}

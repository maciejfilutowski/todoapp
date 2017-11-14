package com.example.demo.devBootstrap;

import com.example.demo.model.*;
import com.example.demo.repositories.ProjectRepository;
import com.example.demo.repositories.TaskRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by filutma1 on 2017-11-14.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public DevBootstrap(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        taskRepository.saveAll(getTasks());
    }

    private List<Task> getTasks() {

        Optional<Project> project = projectRepository.findByDescription("Project 1");

        List<Task> tasks = new ArrayList<>(2);

        Task task1 = new Task();
        task1.setTaskName("Identify resources to be monitored.");
        task1.setStatus(ETaskStatus.OPEN);
        task1.setPriority(ETaskPriority.MEDIUM);
        task1.getProjects().add(project.get());
        TaskDescription taskDescription1 = new TaskDescription();
        taskDescription1.setDescription("\n" +
                "    Design a relatively simple business system.\n" +
                "    Create the Automated Business Systems configuration file and XML definitions for the business system.\n" +
                "    Test the Automated Business Systems file and XML definitions to verify resource inclusion and placement.");
        task1.setTaskDescription(taskDescription1);
        task1.setDateAdded(new Date());

        Task task2 = new Task();
        task2.setTaskName("Install production servers and prerequisite software.");
        task2.setStatus(ETaskStatus.COMPLETED);
        task2.setPriority(ETaskPriority.HIGH);
        task2.getProjects().add(project.get());
        TaskDescription taskDescription2 = new TaskDescription();
        taskDescription2.setDescription("\n" +
                "    Create databases on the history server.\n" +
                "    Set up and test jobs on the database server to produce the database backup.\n" +
                "    Set up and test jobs to copy backup databases to the history server.\n" +
                "    Set up and test jobs to replicate events to the history server.");
        task2.setTaskDescription(taskDescription2);
        task2.setDateAdded(new Date());

        tasks.add(task1);
        tasks.add(task2);

        return tasks;
    }
}

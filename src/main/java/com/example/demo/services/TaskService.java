package com.example.demo.services;

import com.example.demo.model.Task;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by filutma1 on 2017-11-14.
 */
public interface TaskService {
    Set<Task> getAllTasks();
}

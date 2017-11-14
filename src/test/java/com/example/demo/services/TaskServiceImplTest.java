package com.example.demo.services;

import com.example.demo.model.Task;
import com.example.demo.repositories.TaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by filutma1 on 2017-11-14.
 */
public class TaskServiceImplTest {

    TaskServiceImpl taskService;

    @Mock
    TaskRepository taskRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        taskService = new TaskServiceImpl(taskRepository);

    }
    @Test
    public void getAllTasks() {

        Task task = new Task();
        HashSet<Task> taskHashSet = new HashSet<>();
        taskHashSet.add(task);

        when(taskService.getAllTasks()).thenReturn(taskHashSet);

        Set<Task> taskSet = taskService.getAllTasks();

        assertEquals(taskSet.size(), 1);
        verify(taskRepository, times(1)).findAll();

    }

}
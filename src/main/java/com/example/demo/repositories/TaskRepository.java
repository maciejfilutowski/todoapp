package com.example.demo.repositories;

import com.example.demo.model.Task;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by filutma1 on 2017-11-14.
 */
public interface TaskRepository extends CrudRepository<Task, Long> {
}

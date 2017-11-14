package com.example.demo.repositories;

import com.example.demo.model.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by filutma1 on 2017-11-14.
 */
public interface ProjectRepository extends CrudRepository<Project, Long>{

    Optional<Project> findByDescription(String description);

}

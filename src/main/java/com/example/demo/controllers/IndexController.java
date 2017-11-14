package com.example.demo.controllers;

import com.example.demo.model.Project;
import com.example.demo.repositories.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by filutma1 on 2017-11-14.
 */
@Controller
public class IndexController {

    private ProjectRepository projectRepository;

    public IndexController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage() {

        Optional<Project> project = projectRepository.findByDescription("Project 2");
        System.out.println(project.get().getDescription());

        return "index";
    }
}

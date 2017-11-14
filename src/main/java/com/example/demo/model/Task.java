package com.example.demo.model;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by filutma1 on 2017-11-14.
 */
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskName;

    @OneToOne(cascade = CascadeType.ALL)
    private TaskDescription taskDescription;

    private Date dateAdded;

    @Enumerated(value = EnumType.STRING)
    private ETaskStatus status;

    @Enumerated(value = EnumType.STRING)
    private ETaskPriority priority;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "task")
    private Set<Comment> comments = new HashSet<>();

    @ManyToMany
    @JoinTable (name = "task_projects",
                joinColumns = @JoinColumn (name = "task_id"),
                inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projects = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public TaskDescription getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(TaskDescription taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public ETaskStatus getStatus() {
        return status;
    }

    public void setStatus(ETaskStatus status) {
        this.status = status;
    }

    public ETaskPriority getPriority() {
        return priority;
    }

    public void setPriority(ETaskPriority priority) {
        this.priority = priority;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}

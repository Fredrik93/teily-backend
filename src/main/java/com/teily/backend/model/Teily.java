package com.teily.backend.model;

import io.netty.util.internal.StringUtil;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Document(collection = "teilys")
public class Teily
{

    @Id
    // task id
    String id;
    // Task title
    String task;
    // Is completed or not
    boolean isCompleted;
    // user id
    private String userId;
    // The date that the task was created
    private final LocalDateTime dateOfCreation;
    // The date that the task was completed
    private LocalDateTime dateOfCompletion;

    public Teily(String id, String task, boolean isCompleted, String userId, LocalDateTime dateOfCreation, LocalDateTime dateOfCompletion)
    {
        this.id = id;
        this.task = task;
        this.isCompleted = isCompleted;
        this.userId = userId;
        this.dateOfCreation = dateOfCreation;
        this.dateOfCompletion = dateOfCompletion;

    }

    public String getId()
    {
        return id;
    }

    public String getTask()
    {
        return task;
    }

    public boolean isCompleted()
    {
        return isCompleted;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setTask(String task)
    {
        this.task = task;
    }

    public LocalDateTime getDateOfCreation()
    {
        return dateOfCreation;
    }

    public LocalDateTime getDateOfCompletion()
    {
        return dateOfCompletion;
    }

    public void setDateOfCompletion(LocalDateTime dateOfCompletion)
    {
        this.dateOfCompletion = dateOfCompletion;
    }

    /**
     * Inverts the boolean, so true becomes false and false becomes true.
     */
    public void toggleCompleted()
    {
        isCompleted = !isCompleted;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

}
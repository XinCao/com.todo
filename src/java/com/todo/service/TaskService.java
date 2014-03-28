package com.todo.service;

import com.todo.mapper.TaskMapper;
import com.todo.model.Task;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author caoxin
 */
@Service
public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    public void addTask(Task task) {
        if (task == null) {
            return;
        }
        this.taskMapper.insertTask(task);
    }

    public void removeTask(Task task) {
        if (task == null) {
            return;
        }
        this.taskMapper.deleteTask(task);
    }

    public void updateTask(Task task) {
        if (task == null) {
            return;
        }
        this.taskMapper.updateTask(task);
    }

    public List<Task> getTasks(Task task) {
        if (task == null) {
            return null;
        }
        return this.taskMapper.selectTaskList(task);
    }

    public Task getTask(Task task) {
        if (task == null) {
            return null;
        }
        return this.taskMapper.selectTask(task);
    }
}
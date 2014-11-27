package com.xincao.todo_mvn.service;

import com.xincao.todo_mvn.mapper.TaskMapper;
import com.xincao.todo_mvn.model.Task;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author caoxin
 */
@Service
public class TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private TaskMapper taskMapper;

    public void addTask(Task task) {
        if (task == null) {
            logger.warn("param is NULL");
            return;
        }
        this.taskMapper.insertTask(task);
    }

    public void removeTask(Task task) {
        if (task == null) {
            logger.warn("param is NULL");
            return;
        }
        this.taskMapper.deleteTask(task);
    }

    public void updateTask(Task task) {
        if (task == null) {
            logger.warn("param is NULL");
            return;
        }
        this.taskMapper.updateTask(task);
    }

    public List<Task> getTasks(Task task) {
        if (task == null) {
            logger.warn("param is NULL");
            return null;
        }
        return this.taskMapper.selectTaskList(task);
    }

    public Task getTask(Task task) {
        if (task == null) {
            logger.warn("param is NULL");
            return null;
        }
        return this.taskMapper.selectTask(task);
    }
}
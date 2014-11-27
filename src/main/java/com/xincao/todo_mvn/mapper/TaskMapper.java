package com.xincao.todo_mvn.mapper;

import com.xincao.todo_mvn.model.Task;
import java.util.List;

/**
 *
 * @author caoxin
 */
public interface TaskMapper {

    public void insertTask(Task task);

    public void deleteTask(Task task);

    public void updateTask(Task task);

    public Task selectTask(Task task);

    public List<Task> selectTaskList(Task task);
}
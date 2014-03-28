package com.todo.service;

import com.todo.mapper.TodoMapper;
import com.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author caoxin
 */
@Service
public class TodoService {
    
    @Autowired
    private TodoMapper todoMapper;

    public void addTodo(Todo todo) {
        if (todo != null) {
            todoMapper.insertTodo(todo);
        }
    }
}

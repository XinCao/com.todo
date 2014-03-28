package com.todo.service;

import com.todo.model.Todo;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author caoxin
 */
public class TodoServiceTest extends TestCase {
    
    private ApplicationContext ac;
    private TodoService todoService;

    public TodoServiceTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        this.ac = ACService.getAC();
        this.todoService = ac.getBean(TodoService.class);
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testAddTodo() {
        Todo todo = new Todo();
        todo.setId(1);
        this.todoService.addTodo(todo);
    }
}

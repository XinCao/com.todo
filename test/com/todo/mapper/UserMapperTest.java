package com.todo.mapper;

import com.todo.model.User;
import com.todo.service.ACService;
import java.util.Date;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author caoxin
 */
public class UserMapperTest extends TestCase {
    
    private ApplicationContext ac;
    private UserMapper userMapper;
    
    public UserMapperTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.ac = ACService.getAC();
        this.userMapper = ac.getBean(UserMapper.class);
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testInsertUser() {

    }

//    public void testDeleteUser() {
//      
//    }
//
//    public void testUpdateUser() {
//    }
//
//    public void testSelectUser() {
//    }
//
//    public void testSelectUserList() {
//    }
}

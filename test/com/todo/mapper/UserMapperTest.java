package com.todo.mapper;

import com.todo.model.User;
import com.todo.service.ACService;
import junit.framework.TestCase;
import org.mybatis.caches.memcached.MemcachedCache;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author caoxin
 */
public class UserMapperTest extends TestCase {

    private ApplicationContext ac;
    private UserMapper userMapper;
    private static final String group = "mapper_id";
    private MemcachedCache memcachedCache = new MemcachedCache(group);

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
        User user = new User();
        this.userMapper.insertUser(user);
        user = this.userMapper.selectUser(user.getAccount());
        memcachedCache.getObject("");
    }
}
package com.todo.mapper;

import com.todo.model.User;
import com.todo.service.ACService;
import junit.framework.TestCase;
import org.mybatis.caches.memcached.MemcachedCache;
import org.springframework.context.ApplicationContext;

/**
 * mybatis 自定义二级缓存memcached测试
 * 
 * @author caoxin
 */
public class UserMapperTest extends TestCase {

    private ApplicationContext ac;
    private UserMapper userMapper;
    private static final String mapperId = User.class.getName(); // I don't know this mean
    private final MemcachedCache memcachedCache = new MemcachedCache(mapperId);

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
        user.setAccount("caoxin");
        user.setEmail("jingxin191314@foxmail.com");
        user.setPasswd("password");
        this.userMapper.insertUser(user);
        user = this.userMapper.selectUser(user.getAccount());
        Object o = memcachedCache.getObject("selectUser");
        assertNotNull(o);
        user = (User)o;
        System.out.println(user.toString());
    }
}
package com.todo.mapper;

import com.todo.model.User;
import java.util.List;

/**
 *
 * @author caoxin
 */
public interface UserMapper {

    public void insertUser(User user);

    public void deleteUser(String account);

    public void updateUser(User user);

    public User selectUser(String account);

    public List<User> selectUserList(User user);
}
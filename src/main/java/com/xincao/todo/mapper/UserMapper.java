package com.xincao.todo.mapper;

import com.xincao.todo.model.User;
import java.util.List;

/**
 *
 * @author caoxin
 */
public interface UserMapper {

    public void insertUser(User user);

    public void deleteUser(String account);

    public void updateUser(User user);

    public User selectUserByAccount(String account);
    
    public User selectUserByEmail(String email);

    public List<User> selectUserList(User user);
}
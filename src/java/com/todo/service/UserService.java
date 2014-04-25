package com.todo.service;

import com.todo.mapper.UserMapper;
import com.todo.model.User;
import com.todo.util.MdImplement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author caoxin
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加用户
     * 
     * @param user
     * @return 
     */
    public boolean createUser(User user) {
        if (user.againPasswdOk()) {
            user.setPasswd(MdImplement.encodeMD5To32(user.getPasswd().toLowerCase().getBytes()));
            this.userMapper.insertUser(user);
            return true;
        }
        return false;
    }

    /**
     * 身份识别
     * 
     * @param user
     * @return 
     */
    public boolean loginCheck(User user) {
        boolean isOk = true;
        String inputPass = MdImplement.encodeMD5To32(user.getPasswd().toLowerCase().getBytes());
        String pass = this.getUser(user.getAccount()).getPasswd();
        if (inputPass.trim().equalsIgnoreCase(pass)) {
            // 添加权限
        } else {
            isOk = false;
        }
        return isOk;
    }

    public void updateUser(User user) {
        if (user == null) {
            logger.warn("param is NULL");
            return;
        }
        this.userMapper.updateUser(user);
    }

    public User getUser(String account) {
        if (account == null || account.isEmpty()) {
            logger.warn("param is NULL");
            return null;
        }
        return userMapper.selectUser(account);
    }
}
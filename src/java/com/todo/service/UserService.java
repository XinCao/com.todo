package com.todo.service;

import com.todo.mapper.UserMapper;
import com.todo.model.User;
import com.todo.util.MdImplement;
import com.todo.util.ValidateString;
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
        boolean isOk = this.inputUserInfoCheck(user);
        if (isOk) {
            user.setPasswd(MdImplement.encodeMD5To32(user.getPasswd().toLowerCase().getBytes()));
            this.userMapper.insertUser(user);
        }
        return isOk;
    }

    /**
     * 身份识别
     * 
     * @param user
     * @return 
     */
    public boolean loginCheck(User user) {
        boolean isOk = this.inputUserInfoCheck(user);
        if (isOk) {
            String inputPass = MdImplement.encodeMD5To32(user.getPasswd().toLowerCase().getBytes());
            String pass = this.getUser(user.getAccount()).getPasswd();
            if (!inputPass.trim().equalsIgnoreCase(inputPass)) {
                isOk = false;
            }
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

    /**
     * 表单输入数据进行检查
     * 
     * @param user
     * @return 
     */
    private boolean inputUserInfoCheck (User user) {
        if (user == null) {
            logger.warn("param is NULL");
            return false;
        }
        boolean isOk = true;
        if (user.getAccount() == null || user.getAccount().length() < 6 && !ValidateString.isCommonStr(user.getAccount())) {
            isOk = false;
        }
        if (user.getPasswd() == null || user.getPasswd().length() < 6 && !ValidateString.isCommonStr(user.getPasswd())) {
            isOk = false;
        }
        if (user.getEmail() == null || !ValidateString.isMailStr(user.getEmail())) {
            isOk = false;
        }
        return isOk;
    }
}
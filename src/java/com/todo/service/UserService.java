package com.todo.service;

import com.todo.mapper.UserMapper;
import com.todo.model.ResultStatus;
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
     * 添加用户（普通角色）
     *
     * @param user
     * @return
     */
    public boolean createUser(User user) {
        if (user.againPasswdOk()) {
            user.setPasswd(MdImplement.encodeMD5To32(user.getPasswd().toLowerCase().getBytes()));
            user.setUserRole(User.UserRole.COMMON_USER_ROLE.getId());
            user.setActivited(ResultStatus.NO.getNo()); // 未激活状态
            MailService.sendActivitedLink("localhost:8080", "/user/do_activited_account/" + user.getAccount(), user.getEmail());
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
        boolean isOk = false;
        User realUser = this.getUser(user.getAccount());
        if (realUser != null) {
            String pass = realUser.getPasswd();
            if (realUser.getActivited() == ResultStatus.YES.getNo() && user.getPasswd().trim().equalsIgnoreCase(pass)) {
                isOk = true;
                user.setUserRole(realUser.getUserRole());
                // 添加权限
            }
        }

        return isOk;
    }

    /**
     * 激活帐号
     *
     * @param account
     * @return
     */
    public boolean doActivitedAccount(String account) {
        boolean ok = false;
        User user = this.getUser(account);
        if (user.getActivited() == ResultStatus.NO.getNo()) {
            user.setActivited(ResultStatus.YES.getNo());
            this.updateUser(user);
            ok = true;
        }
        return ok;
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

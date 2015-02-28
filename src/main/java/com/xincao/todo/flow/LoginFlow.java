package com.xincao.todo.flow;

import com.xincao.todo.model.StringPair;
import com.xincao.todo.model.User;
import com.xincao.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author caoxin
 */
@Service(value = "loginFlow") // 使用@Service， 因为，暂时不能实现Flow注解来替换
public class LoginFlow extends AbstractFlow<StringPair> {

    @Autowired
    private UserService userService;

    @Override
    protected boolean canPerform(StringPair sp) {
        User user = new User();
        user.setAccount(sp.getParam1());
        user.setPasswd(sp.getParam2());
        return userService.loginCheck(user);
    }

    @Override
    protected void perform(StringPair sp) {
        logger.info("login ok!");
    }

    @Override
    protected StringPair parse(Object... params) {
        if (params != null && params.length == 2) {
            return new StringPair(params[0], params[1]);
        }
        return null;
    }
}
package com.todo.flow;

import com.todo.model.StringPair;
import com.todo.model.User;
import com.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author caoxin
 */
@Flow(value = "loginFlow")
public class LoginFlow extends AbstractFlow<StringPair> {

    @Autowired
    private UserService userService;

    @Override
    protected boolean canAction(StringPair sp) {
        User user = new User();
        user.setAccount(sp.getParam1());
        user.setPasswd(sp.getParam2());
        return userService.loginCheck(user);
    }

    @Override
    protected void actionImp(StringPair sp) {
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
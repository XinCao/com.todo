package com.todo.controller.app;

import com.todo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author caoxin
 */
@Controller
@RequestMapping(value = "/app/user")
public class UserAjaxController {

    private static final Logger logger = LoggerFactory.getLogger(UserAjaxController.class);

    @RequestMapping(value="login_check", method = RequestMethod.POST)
    public User loginCheckAction() {
        return null;
    }
}

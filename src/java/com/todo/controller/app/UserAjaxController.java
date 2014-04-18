package com.todo.controller.app;

import com.todo.model.User;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author caoxin
 */
@Controller
@RequestMapping(value = "/app/user")
public class UserAjaxController {

    private static final Logger logger = LoggerFactory.getLogger(UserAjaxController.class);

    @RequestMapping(value="login_check", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> loginCheckAction(@RequestParam(value="account", required = true)String account, @RequestParam(value="password", required = true)String password) {
        return null;
    }

    @RequestMapping(value="register", method = RequestMethod.POST)
    public User registerAction() {
        return null;
    }
    
}

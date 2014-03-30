package com.todo.controller;

import com.todo.model.User;
import com.todo.service.UserService;
import com.todo.util.ValidateString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户管理
 *
 * @author caoxin
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    @RequestMapping(value = "/register_form_user", method = RequestMethod.GET)
    public String registerFormUserAction() {
        return "register_form_user";
    }

    @RequestMapping(value = "/do_register_user", method = RequestMethod.POST)
    public String registerUserAction(@ModelAttribute User user) {
        String page;
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
        if (isOk) {
            userService.addUser(user);
            page = "login_form_user";
        } else {
            page = "register_form_user";
        }
        return page;
    }

    @RequestMapping(value = "/login_form_user", method = RequestMethod.GET)
    public String loginFormUserAction() {
        return "/user/login_form_user";
    }

    @RequestMapping(value = "/login_user", method = RequestMethod.POST)
    public String loginUserAction(@ModelAttribute User user) {
        boolean isOk = true;
        if (user.getAccount() == null || user.getAccount().length() < 6 && !ValidateString.isCommonStr(user.getAccount())) {
            isOk = false;
        }
        if (user.getPasswd() == null || user.getPasswd().length() < 6 && !ValidateString.isCommonStr(user.getPasswd())) {
            isOk = false;
        }
        
        return "";
    }
}
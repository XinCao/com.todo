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

    /**
     * 注册用户表单
     * 
     * @return 
     */
    @RequestMapping(value = "/register_form_user", method = RequestMethod.GET)
    public String registerFormUserAction() {
        return "/user/register_form_user";
    }

    /**
     * 注册用户
     * 
     * @param user
     * @return 
     */
    @RequestMapping(value = "/do_register_user", method = RequestMethod.POST)
    public String doRegisterUserAction(@ModelAttribute User user) {
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
            page = "/user/login_form_user";
        } else {
            page = "/user/register_form_user";
        }
        return page;
    }

    /**
     * 登陆用户表单
     * 
     * @return 
     */
    @RequestMapping(value = "/login_form_user", method = RequestMethod.GET)
    public String loginFormUserAction() {
        return "/user/login_form_user";
    }

    /**
     * 用户登陆
     * 
     * @param user
     * @return 
     */
    @RequestMapping(value = "/do_login_user", method = RequestMethod.POST)
    public String doLoginUserAction(@ModelAttribute User user) {
        String page;
        boolean isOk = true;
        if (user.getAccount() == null || user.getAccount().length() < 6 && !ValidateString.isCommonStr(user.getAccount())) {
            isOk = false;
        }
        if (user.getPasswd() == null || user.getPasswd().length() < 6 && !ValidateString.isCommonStr(user.getPasswd())) {
            isOk = false;
        }
        if (isOk) {
            this.userService.addUser(user);
            page = "task/wait_to_be_done_task";
        } else {
            page = "/user/login_form_user";
        }
        return page;
    }
}
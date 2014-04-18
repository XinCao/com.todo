package com.todo.controller;

import com.todo.model.User;
import com.todo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
     * @param model
     * @return 
     */
    @RequestMapping(value = "/register_form_user", method = RequestMethod.GET)
    public String registerFormUserAction(Model model) {
        model.addAttribute("User", new User());
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
        boolean isOk = userService.createUser(user);
        if (isOk) {
            userService.createUser(user);
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
     * 登录包括两部分内容，1.身份识别，2权限限制（缺少）
     * 
     * @param user
     * @return 
     */
    @RequestMapping(value = "/do_login_user", method = RequestMethod.POST)
    public String doLoginUserAction(@ModelAttribute User user) {
        String page;
        boolean isOk = userService.loginCheck(user);
        if (isOk) {
            /**
             * 这里应该添加权限
             */
            page = "task/wait_to_be_done_task";
        } else {
            page = "/user/login_form_user";
        }
        return page;
    }
}
package com.todo.controller;

import com.todo.model.User;
import com.todo.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户管理（没有用户帐号激活功能）
 *
 * @author caoxin
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
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
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/do_register_user", method = RequestMethod.POST)
    public String doRegisterUserAction(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/user/register_form_user";
        } else {
            this.userService.createUser(user);
            return "redirect:/user/login_form_user";

        }
    }

    /**
     * 登陆用户表单
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/login_form_user", method = RequestMethod.GET)
    public String loginFormUserAction(Model model) {
        model.addAttribute("User", new User());
        return "/user/login_form_user";
    }

    /**
     * 用户登陆 登录包括两部分内容，1.身份识别，2权限限制（缺少）
     *
     * @param user
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/do_login_user", method = RequestMethod.POST)
    public String doLoginUserAction(@Valid User user, BindingResult bindingResult) {
        boolean ok = true;
        if (bindingResult.hasErrors()) {
            ok = false;
        } else {
            ok = this.userService.loginCheck(user);
        }
        if (ok) {
            return "redirect:/user/do_login_user/session";
        } else {
            return "redirect:/user/login_form_user";
        }
    }
}
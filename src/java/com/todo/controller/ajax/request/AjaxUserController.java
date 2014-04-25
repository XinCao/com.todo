package com.todo.controller.ajax.request;

import com.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author caoxin
 */
@Controller
@RequestMapping(value = "/user/ajax/")
public class AjaxUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "check_account/{check_account}", method = RequestMethod.GET)
    public @ResponseBody
    String checkAccountAction(@PathVariable("check_account") String account) {
        boolean isOk = userService.getUser(account) == null;
        if (isOk) {
            return "{is_ok : 1}";
        } else {
            return "{is_ok : 0}";
        }
    }
}
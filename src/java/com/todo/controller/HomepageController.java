package com.todo.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 主界面显示（产品的介绍）
 *
 * @author caoxin
 */
@Controller
@RequestMapping("/")
public class HomepageController {

    @RequestMapping(method = RequestMethod.GET)
    public String showAction(Map<String, Object> map) {
        return "homepage";
    }
}
package com.todo.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author caoxin
 */
@Controller
@RequestMapping("/")
public class ComTodoController {

    @RequestMapping(value = {"{key}", "index/{key}", "homepage/{key}"}, method=RequestMethod.GET)
    public ModelAndView homepageAction(@PathVariable(value = "key")String key, @RequestParam(value ="account", required = true, defaultValue = "account")String account) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", key);
        map.put("account", account);
        return new ModelAndView("homepage", map);
    }
}
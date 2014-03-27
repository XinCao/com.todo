package com.todo;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author caoxin
 */
@Controller
public class ComTodo {

    @RequestMapping({"/", "index", "homepage"})
    public String homepageAction(Map<String, Object> model) {
        model.put("test", "success");
        return "homepage";
    }
}

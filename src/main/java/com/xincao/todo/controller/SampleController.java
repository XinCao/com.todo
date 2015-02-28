package com.xincao.todo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author xin.cao@100credit.com
 */
@Controller
@RequestMapping("/sample")
public class SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public String sampleAction () {
        return "/sample/sample";
    }
}

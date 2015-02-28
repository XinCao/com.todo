package com.xincao.todo.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author caoxin
 */
public class ACService implements ApplicationContextAware {

    private static ApplicationContext ac;

    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        ACService.ac = ac;
    }

    public static ApplicationContext getAC() {
        if (ac != null) {
            return ac;
        } else {
        }
        return null;
    }
}
package com.xincao.todo.controller;

import com.xincao.todo.model.User;
import static com.xincao.todo.model.User.USER_ROLE;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 暂时实现一种角色（登录用户）
 *
 * @author caoxin
 */
public class UserRoleInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(UserRoleInterceptor.class);
    private static final String defaultUrl = "/user/login_form_user";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(true);
        String url = request.getRequestURI();
        if (session.getAttribute(USER_ROLE) == null || !session.getAttribute(USER_ROLE).equals(User.UserRole.COMMON_USER_ROLE.getKey())) {
            ModelAndView mv = new ModelAndView(defaultUrl);
            mv.addObject("forward", url);
            throw new ModelAndViewDefiningException(mv);
        }
        return true;
    }
}
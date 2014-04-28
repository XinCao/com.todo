package com.todo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author caoxin
 */
public class LoginUserController extends AbstractController {

    private static final String COMMON_USER_ROLE = "common_user_role";

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute(COMMON_USER_ROLE, COMMON_USER_ROLE);
        return new ModelAndView(new RedirectView("/task/wait_to_be_done_task"));
    }

}
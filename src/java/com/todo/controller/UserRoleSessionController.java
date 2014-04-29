package com.todo.controller;

import com.todo.model.User;
import static com.todo.model.User.USER_ROLE;
import com.todo.model.User.UserRole;
import com.todo.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author caoxin
 */
public class UserRoleSessionController extends AbstractController {

    @Autowired
    private UserService userService;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        boolean ok;
        String account = request.getParameter("account");
        String passwd = request.getParameter("passwd");
        User user = new User();
        user.setAccount(account);
        user.setPasswd(passwd);
        ok = this.userService.loginCheck(user);
        if (ok) {
            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute(USER_ROLE, UserRole.fromId(user.getUserRole()).getKey());
            return new ModelAndView(new RedirectView("/task/wait_to_be_done_task"));
        } else {
            return new ModelAndView(new RedirectView("/user/login_form_user"));
        }
    }

}
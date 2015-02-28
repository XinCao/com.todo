package com.xincao.todo.controller;

import com.xincao.todo.log.LogServiceImplementWithLogback;
import com.xincao.todo.model.User;
import static com.xincao.todo.model.User.USER_ROLE;
import com.xincao.todo.model.User.UserRole;
import com.xincao.todo.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(UserRoleSessionController.class);
    @Autowired
    private LogServiceImplementWithLogback logServiceImplementWithLogback;

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
            logServiceImplementWithLogback.user_login(account, UserRole.fromId(user.getUserRole()).getKey());
            // 登录成功, 跳转的界面
            return new ModelAndView(new RedirectView("/todo/sample/sample"));
        } else {
            logger.error("login error account={}", account);
            // 登录失败
            return new ModelAndView(new RedirectView("/todo/user/login_form_user"));
        }
    }

}
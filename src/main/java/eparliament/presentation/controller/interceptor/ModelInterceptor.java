package eparliament.presentation.controller.interceptor;

import eparliament.dto.LoggedUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by alexandrrusanov on 9/9/17.
 */
public class ModelInterceptor extends HandlerInterceptorAdapter{

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof LoggedUser) {
            LoggedUser loggedUser = (LoggedUser) authentication.getPrincipal();
            modelAndView.addObject("loggedUser", loggedUser.getUser());
        }
    }
}

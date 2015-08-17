package com.qc.fi.web.interceptor;

import com.qc.fi.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SecurityInterceptor extends HandlerInterceptorAdapter{
    private static final Logger LOG = LoggerFactory.getLogger(SecurityInterceptor.class);

    private List<String> excludedUrls;

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String requestUri = request.getRequestURI();
        for (String url : excludedUrls) {
            if (requestUri.endsWith(url)) {
                return true;
            }
        }

        // intercept
        HttpSession session = request.getSession();
        Object currentUserObj = session.getAttribute("currentUser");
        if (currentUserObj == null) {
            throw new AuthorizationException();
        } else {
            if (handler instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                Permission permission = handlerMethod.getMethodAnnotation(Permission.class);
                User currentUser = (User) currentUserObj;
                if (permission != null
                        && permission.userType() != null
                        && permission.userType().getCode() != currentUser.getUserType()) {
                    throw new AuthorizationException();
                }
            }
        }
        return true;
    }
}

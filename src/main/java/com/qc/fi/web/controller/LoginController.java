package com.qc.fi.web.controller;

import com.qc.fi.model.User;
import com.qc.fi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("login")
@SessionAttributes("currentUser")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> login(HttpServletRequest request, Model model, User loginUser) {
        RequestContext requestContext = new RequestContext(request);
        User user = userService.getByUserNamePwd(loginUser.getUserName(), loginUser.getPassword());
        ModelAndView modelAndView = new ModelAndView();
        if (user != null) {
            modelAndView.addObject("user", user);
            model.addAttribute("currentUser", user);
        } else {
            modelAndView.addObject("error", true);
            modelAndView.addObject("message", requestContext.getMessage("login.fail"));
        }
        return modelAndView.getModel();
    }
}

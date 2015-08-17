package com.qc.fi.web.controller;

import com.qc.fi.model.User;
import com.qc.fi.model.UserType;
import com.qc.fi.service.UserService;
import com.qc.fi.web.interceptor.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
@SessionAttributes("currentUser")
class UserController {
    @Autowired
    private UserService userService;

    @Permission(userType = UserType.ADMIN)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> saveUser(User user) {
        user = userService.add(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id", user.getId());
        return modelAndView.getModel();
    }

    @Permission(userType = UserType.ADMIN)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public Map<String, Object> delete(@PathVariable("id") long id) {
        userService.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("success", true);
        return modelAndView.getModel();
    }

    @Permission(userType = UserType.ADMIN)
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, Object> updateUser(User user) {
        userService.update(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("success", true);
        return modelAndView.getModel();
    }

    @RequestMapping("/get/{id}")
    public Map<String, Object> updateUser(@PathVariable long id) {
        User user = userService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        return modelAndView.getModel();
    }

    @Permission(userType = UserType.ADMIN)
    @RequestMapping("/list")
    public @ResponseBody Map<String, Object> list() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.list();
        modelAndView.addObject("users", users);
        return modelAndView.getModel();
    }
}

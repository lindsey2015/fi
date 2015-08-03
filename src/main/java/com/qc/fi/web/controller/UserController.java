package com.qc.fi.web.controller;

import com.qc.fi.model.User;
import com.qc.fi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/24.
 */
@Controller
@RequestMapping("user")
class UserController {
    @Autowired
    private UserService userService;
   // private  HttpSession session;

    //��ʾ�û��б�
    @RequestMapping("/list")
    public ModelAndView list() {
        List<User> users = new ArrayList<User>();
        users = userService.findAll();
        return new ModelAndView("/user/list", "users", users);
    }

    //ɾ���û�
    @RequestMapping("/delete")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/list.ftl";

    }

    //�����û�����
    @RequestMapping("/add")
    public ModelAndView addUser() {
       // User  user=new User();
        return new ModelAndView("/user/add");
    }

    //�������湦��
    @RequestMapping("/save")
    public String saveUser(User user) {
       /* user.setUserName(session.getAttribute("userName").toString());
        user.setPassword(session.getAttribute("password").toString());
        user.setUserType(session.getAttribute("userType").toString());
        user.setCompanyName(session.getAttribute("companyName").toString());
        user.setChannelName(session.getAttribute("channelName").toString());
        user.setChannelContact(session.getAttribute("channelContact").toString());
        user.setChannelContactType(session.getAttribute("channelContactType").toString());
        user.setContact(session.getAttribute("contact").toString());
        user.setCellPhone(session.getAttribute("cellPhone").toString());
        user.setPhone(session.getAttribute("phone").toString());
        user.setEmail(session.getAttribute("email").toString());*/

        userService.add(user);

        return "redirect:list.ftl";
    }
/*${user.name}*/
    //�޸��û�����
    @RequestMapping("/edit")
    public ModelAndView editUser(@PathVariable("id") int id,HttpServletRequest req) {
        User user = userService.getById(id);
        //���ݻ���
        req.setAttribute("user",user);
        return new ModelAndView("/user/edit");
    }

    //�޸ı��湦��
    @RequestMapping("/update")
    public String updateUser(User user) {

        userService.update(user);

        return "redirect:/list.ftl";
    }

}

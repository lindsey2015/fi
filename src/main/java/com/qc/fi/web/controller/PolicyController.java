package com.qc.fi.web.controller;

import com.qc.fi.model.Plan;
import com.qc.fi.model.Policy;
import com.qc.fi.model.User;
import com.qc.fi.model.UserType;
import com.qc.fi.service.PolicyService;
import com.qc.fi.web.interceptor.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("policy")
@SessionAttributes("currentUser")
public class PolicyController {
    @Autowired
    PolicyService policyService;

    @Permission(userType = UserType.NORMAL)
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addPolicy(Policy policy) {
        //TODO: implement the correct logic
        User user = new User();
        user.setId(2);
        Plan plan = new Plan();
        plan.setId(1);

        policy.setUser(user);
        policy.setPlan(plan);

        long id = policyService.add(policy);

        Map<String, Object> result = new HashMap<>();
        result.put("id", id);
        return result;
    }

    @RequestMapping(value="/delete/{id}")
    public @ResponseBody Map<String, Object> deletePolicy(@PathVariable long id) {
        User user = new User();
        user.setId(2);

        // if user has permission to delete
        Policy policy = policyService.findOne(id);
        Map<String, Object> result = new HashMap<>();
        if (!user.isAdmin() && policy.getUser().getId() != user.getId()) {
            result.put("error", "true");
            result.put("message", "you don't have permission");
            return result;
        }

        policyService.delete(id);
        result.put("success", "true");
        return result;
    }

    @RequestMapping(value="/{id}")
    public @ResponseBody Policy getPolicy(@PathVariable long id) {
        //TODO: implement the correct logic
        User user = new User();
        user.setId(2);
        Plan plan = new Plan();
        plan.setId(1);

        Policy policy = policyService.findOne(id);
        //TODO: if user is normal user, check if policy belongs to this user
        Map<String, Object> result = new HashMap<>();
        if (!user.isAdmin() && policy.getUser().getId() != user.getId()) {
            result.put("error", "true");
            result.put("message", "you don't have permission");
            return null;
        }
        result.put("policy", policy);
        return policy;
    }

    @RequestMapping(value="/search")
    public @ResponseBody List<Policy> searchPolicy(Date startDate, Date endDate) {
        List<Policy> policies = new ArrayList<>();
        return policies;
    }
}

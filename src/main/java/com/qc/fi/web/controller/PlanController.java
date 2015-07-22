package com.qc.fi.web.controller;

import com.qc.fi.model.Plan;
import com.qc.fi.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("plan")
public class PlanController {
    @Autowired
    PlanService planService;

    @RequestMapping("/list")
    public ModelAndView list() {
        List<Plan> plans = planService.findAll();
        return new ModelAndView("/plan/list", "plans", plans);
    }
}

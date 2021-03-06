package com.qc.fi.web.controller;

import com.qc.fi.model.Plan;
import com.qc.fi.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("plan")
public class PlanController extends ModelMap{
    @Autowired
    PlanService planService;

    @RequestMapping("/list")
    public ModelAndView list() {
        List<Plan> plans = planService.findAll();
        return new ModelAndView("/plan/list", "plans", plans);
    }

    @RequestMapping("/delete")
    public String delete(@PathVariable("id") long id){
        planService.delete(id);
        return "redirect:list.ftl";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPlan(Plan plan){
        return new ModelAndView("/plan/add", "command", plan);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String savePlan(Plan plan){
        planService.add(plan);
        return "redirect:list.ftl";
    }

    @RequestMapping("/edit")
    public ModelAndView editPlan(@PathVariable("id") long id){
        Plan plan=planService.findOne(id);
        return new ModelAndView("/plan/edit","command",plan);
    }

    public String updatePlan(Plan plan){
        planService.update(plan);
        return "redirect:list.ftl";
    }
}

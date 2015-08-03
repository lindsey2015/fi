package com.qc.fi.web.controller;

import com.qc.fi.model.Plan;
import com.qc.fi.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("plan")
public class PlanController extends ModelMap{
    @Autowired
    PlanService planService;
    //列表
    @RequestMapping("/list")
    public ModelAndView list() {
        List<Plan> plans = planService.findAll();
        return new ModelAndView("/plan/list", "plans", plans);
    }
    //删除
    @RequestMapping("/delete")
    public String delete(@PathVariable("id") long id){
        planService.delete(id);
        return "redirect:list.ftl";

    }
    //新增的界面
    @RequestMapping("/add")
    public ModelAndView addPlan(Plan plan){
        return new ModelAndView("/plan/add", "command", plan);

    }
    //保存新增
    @RequestMapping("/save")
    public String savePlan(Plan plan){
        planService.save(plan);
        return "redirect:list.ftl";
    }

    //修改的界面
    @RequestMapping("/edit")
    public ModelAndView editPlan(@PathVariable("id") long id){
        Plan plan=planService.findOne(id);
        return new ModelAndView("/plan/edit","command",plan);
    }
    //更新编辑
    public String updatePlan(Plan plan){
        planService.update(plan);
        return "redirect:list.ftl";
    }
}

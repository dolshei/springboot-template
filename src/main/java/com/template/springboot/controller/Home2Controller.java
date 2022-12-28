package com.template.springboot.controller;

import com.template.springboot.model.SalaryModel;
import com.template.springboot.service.SalaryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Home2Controller {

    @Autowired
    SalaryService salaryService;

    @RequestMapping(value = "/home2", method = RequestMethod.GET)
    public ModelAndView goHome(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        List<SalaryModel> salaryList = salaryService.getSalary();

        mav.addObject("salaryList", salaryList);
        mav.setViewName("content/home");

        return mav;
    }
}

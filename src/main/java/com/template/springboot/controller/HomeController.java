package com.template.springboot.controller;

import com.template.springboot.model.SalaryModel;
import com.template.springboot.service.SalaryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView goHome(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView();


        // salary 객체 리스트 변수
        List<SalaryModel> salaryList = new ArrayList<SalaryModel>();

        // Salary model
        SalaryModel salaryModel;

        // 첫 번째 데이터
        salaryModel = SalaryModel.builder()
                .id(1)
                .name("AAA")
                .email("AAA@template.com")
                .build();
        salaryList.add(salaryModel);

        // 두 번째 데이터
        salaryModel = SalaryModel.builder()
                .id(2)
                .name("BBB")
                .email("BBB@template.com")
                .build();
        salaryList.add(salaryModel);

        // 세 번째 데이터
        salaryModel = SalaryModel.builder()
                .id(3)
                .name("CCC")
                .email("CCC@template.com")
                .build();
        salaryList.add(salaryModel);

        mav.addObject("salaryList", salaryList);
        mav.setViewName("content/home");

        return mav;
    }
}

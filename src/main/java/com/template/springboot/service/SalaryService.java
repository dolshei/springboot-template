package com.template.springboot.service;

import com.template.springboot.mapper.SalaryMapper;
import com.template.springboot.model.SalaryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryService {

    @Autowired
    public SalaryMapper mapper;

    public List<SalaryModel> getSalary() {
        return mapper.getSalary();
    }
}

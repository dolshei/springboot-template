package com.template.springboot.controller;

import com.template.springboot.service.RestTemplateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class Api2Controller {
    private final RestTemplateService restTemplateService;

    public Api2Controller(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

}

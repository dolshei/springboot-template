package com.template.springboot.controller;

import com.template.springboot.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/text")
    public String text(@RequestParam String account){
        return "Account : " + account;
    }

    @PostMapping("/json")
    public User json(@RequestBody User user){
        return user;
    }
}

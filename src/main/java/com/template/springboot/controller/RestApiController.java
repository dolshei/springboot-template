package com.template.springboot.controller;

import com.template.springboot.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping("/get/{id}")
    public void get(@PathVariable Long id, @RequestBody String name) {
        System.out.println("Get method");
        System.out.println("Get method : " + id);
        System.out.println("Get method : " + name);
    }

    @PostMapping("/post2")
    public void post(@RequestBody User user) {
        System.out.println("Post method : "+ user);
    }
}

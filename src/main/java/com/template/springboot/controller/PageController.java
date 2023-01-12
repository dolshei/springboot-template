package com.template.springboot.controller;

import com.template.springboot.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {
    @RequestMapping("/main")
    public String main() {
        return "content/main";
    }

    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {
        // HttpStatus.CREATED 는 201을 출력하게 한다.
        // body 에는 data 를 넣어준다.
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @ResponseBody
    @GetMapping("/user")
    public User user() {
        // var 은 타입추론을 해서 맞춰준다.
        var user = new User();

        user.setUser("가르마");
        user.setAddress("서울시 강동구");
        return user;
    }
}

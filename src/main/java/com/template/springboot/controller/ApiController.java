package com.template.springboot.controller;

import com.template.springboot.model.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

    @PostMapping("/user2")
    public ResponseEntity user2(@Valid @RequestBody User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError fieldError = (FieldError) objectError;
                String message = objectError.getDefaultMessage();

                System.out.println("--------------------------------");
                System.out.println("Field : " + fieldError.getField());
                System.out.println("Message : " + message);
                System.out.println("================================");

                stringBuilder.append("\n");
                stringBuilder.append("Field : " + fieldError.getField() + "\n");
                stringBuilder.append("message : " + message + "\n");

            });
            // 조건에 맞지 않는다면 BadRequest 와 error 출력
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(stringBuilder.toString());
        }

        return ResponseEntity.ok(user);
    }
}

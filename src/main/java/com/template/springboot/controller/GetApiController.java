package com.template.springboot.controller;

import com.template.springboot.model.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {
    @GetMapping(path = "/hello")
    public String Hello() {
        return "get Hello";
    }

    @GetMapping("path-variable/{name}")
    public String pathVariable(@PathVariable String name) {
        System.out.println("PathVariable : " + name);
        return name;
    }

    @GetMapping("path-variable-param/{pathname}")
    public String pathVariableParam(@PathVariable(name = "pathname") String pathname) {
        System.out.println("PathVariableParam : " + pathname);
        return pathname;
    }

    @GetMapping(path = "query-param01")
    public String queryParam01(@RequestParam Map<String, String> queryParam) {
        // key=value 값으로 데이터를 받기에 Map 으로 구현

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping(path = "query-param02")
    public String queryParam02(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam int age) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + "\n" + email + "\n" + age;
    }

    @GetMapping(path = "query-param03")
    public String queryParam03(UserRequest userRequest) {
        // 이전 방식과 다르게 @RequestParam 을 붙이지 않는다.
        // Spring boot 에서는 parameter 로 객체가 들어오면
        // "?name=steve&email=steve@gmail.com&age=30"와 같은
        // query parameter 에 있는 객체들을 spring boot 에서 판단한다.
        // 그리고 key 에 위치한 값들을 객체의 변수의 이름과 매칭을 해준다.
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}

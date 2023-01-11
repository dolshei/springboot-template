package com.template.springboot.controller;

import com.template.springboot.model.PostRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    // 반환값 없이 받기만 하는 코드
    @PutMapping("/put1")
    public void put1(@RequestBody PostRequestDTO requestDTO) {
        System.out.println(requestDTO);
    }

    // 반환값으로 받은 데이터를 다시 json 으로 보내는 코드
    @PutMapping("/put2")
    public PostRequestDTO put2(@RequestBody PostRequestDTO requestDTO) {
        System.out.println(requestDTO);
        return requestDTO;
    }

    // pathVariable 를 추가한 예시
    @PutMapping("/put3/{userId}")
    public PostRequestDTO put3(@RequestBody PostRequestDTO requestDTO, @PathVariable(name = "userId") Long id) {
        System.out.println(requestDTO);
        return requestDTO;
    }
}

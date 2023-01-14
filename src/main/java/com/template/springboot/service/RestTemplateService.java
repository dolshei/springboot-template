package com.template.springboot.service;

import com.template.springboot.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    // http://localhost:8080/api/server/hello 로 요청해서 response 를 받아오기
    public User hello() {
        // uri 주소 생성
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8080")         // http://localhost 에 호출
                .path("/api/server/hello")
                .queryParam("name", "steve")
                .queryParam("age", 10)
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<User> result = restTemplate.getForEntity(uri, User.class);

        // entity 로 데이터를 가져온다(Get)
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();
    }
}

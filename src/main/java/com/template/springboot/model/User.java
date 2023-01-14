package com.template.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class User {

    @NotBlank           // 공백 허용안함.
    private String user;

    @Max(value = 90)
    private int age;
    @JsonProperty("phone_number")
    // 받아들이는 문자의 형태를 직접 제한하는 방법 (정규식을 사용)
    // message 에는 error 가 발생했을 때 출력할 메세지를 적는다.
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. xxx-xxxx-xxxx")
    private String phoneNumber;
    private String address;
}

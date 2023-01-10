package com.template.springboot.model;

import lombok.Data;

@Data
public class UserRequest {
    String name;
    String email;
    Integer age;
}

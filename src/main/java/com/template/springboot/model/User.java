package com.template.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {
    private String user;
    private int age;
    @JsonProperty("phone_number")
    private String phoneNumber;
    private String address;
}

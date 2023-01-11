package com.template.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostRequestDTO {
    String account;
    String email;
    String address;
    String password;

    @JsonProperty("phone_number")
    String phoneNumber;
}

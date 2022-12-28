package com.template.springboot.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class SalaryModel {
    private int id;
    @NonNull        // Null 값을 허용하지 않는다.
    @Builder.Default
    private String name = "NULL NAME";
    private String email;
}

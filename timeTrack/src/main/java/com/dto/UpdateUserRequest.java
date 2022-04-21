package com.dto;

import lombok.Data;

@Data
public class UpdateUserRequest {

    private Integer id;
    private String name;
    private String description;
}

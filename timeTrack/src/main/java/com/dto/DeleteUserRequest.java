package com.dto;

import lombok.Data;

@Data
public class DeleteUserRequest {

    private Integer id;
    private String name;
    private String description;
}

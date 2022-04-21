package com.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/* Перевозчики информации о пользователе */
public class UserDTO {

    private Integer id;
    private String name;
    private String description;


}

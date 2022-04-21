package com.dto;

/* Класс-запрос пользователя на добавление в список */

import lombok.Data;

@Data
public class AddUserRequest {

    private String name;
    private String description;


}

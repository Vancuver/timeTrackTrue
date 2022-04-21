package com.domain;


import lombok.Data;

@Data
/* Класс нашей сущности(того, что обрабатывается внутри нашей программы) */
public class UserEntity {

    private Integer id;
    private String name;
    private String description;


}

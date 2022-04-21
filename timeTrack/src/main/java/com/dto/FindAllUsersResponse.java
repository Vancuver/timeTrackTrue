package com.dto;

import lombok.Data;

import java.util.List;

@Data
/* Класс который будет давать ответ пользователю на запрос о показе списка */
public class FindAllUsersResponse {

    private List<UserDTO> todos;

    public FindAllUsersResponse(List<UserDTO> todos) {
        this.todos = todos;
    }


}

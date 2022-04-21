package com.dto;

import com.domain.core.validation.CoreError;
import lombok.Data;

import java.util.List;


@Data
/* Класс-ответ на запрос пользователя о добавлении в список */
public class AddUserResponse {

    private Integer createdToDoId;
    private List<CoreError> errors;


}

package com.domain.core;

import com.domain.UserEntity;
import com.dto.FindAllUsersResponse;
import com.dto.UserDTO;
import com.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class FindUsersDoService {

    /* Вписываем зависимость от хранилища данных */
    private final UserRepository repository;

    public FindUsersDoService(UserRepository repository) {
        this.repository = repository;
    }

    /* Метод реализации ответа пользователю на запрос о показе списка */
    public FindAllUsersResponse findAll() {
        var dtos = repository.findAll().stream()       /* Создание "перевозчиков" каждого ответа на запрос пользователя */
                .map(this::convert)                                 /* Каждый элемент проходит конвертацию из сущности в ответ пользователю */
                .toList();                                          /* Создаёт список из этих элементов */
        return new FindAllUsersResponse(dtos);                      /* Возвращает ответ пользователю на запрос о показе списка */
    }

    /* Метод конвертации из сущности в перевозчик информации о пользователе */
    private UserDTO convert(UserEntity entity) {
        return new UserDTO(entity.getId(), entity.getName(), entity.getDescription());
    }
}

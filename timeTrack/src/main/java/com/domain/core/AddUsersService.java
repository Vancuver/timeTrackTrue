package com.domain.core;

import com.domain.UserEntity;
import com.domain.core.validation.ValidationService;
import com.dto.AddUserRequest;
import com.dto.AddUserResponse;
import com.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AddUsersService {

    /* Вписываем зависимость от хранилища данных */
    private final UserRepository repository;
    /* Вписываем зависимость от сервиса валидаци */
    private final ValidationService validationService;


    /* Указываем что переданное хранилище данных и информация от сервиса валидации относятся к этому классу */
    public AddUsersService(UserRepository repository,
                           ValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    /* Метод ответа пользователю на запрос о добавлении в список */
    public AddUserResponse add(AddUserRequest request) {
        /* Выведение на экран полученного запроса */
        System.out.println("Received request: " + request);
        /* Создаём список-результат ошибок после прохождения валидации запросом */
        var validationResult = validationService.validate(request);
        /* Если найдены были ошибки */
        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors: " + validationResult);
            var response = new AddUserResponse();
            response.setErrors(validationResult);
            return response;
        }
        /* Если нет ошибок */

        /* Создаём сущность пользователя из запроса */
        var entity = convert(request);
        var createdEntity = repository.save(entity);
        System.out.println("Successfully saved: " + createdEntity);
        /* Создаём ответ пользователю на запрос */
        var response = new AddUserResponse();
        response.setCreatedToDoId(createdEntity.getId());
        System.out.println("Sending response: " + response);
        return response;
    }

    /* Метод для конвертации запроса в сущность  */
    private UserEntity convert(AddUserRequest request) {
        UserEntity entity = new UserEntity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        return entity;
    }
}

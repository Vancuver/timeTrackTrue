package com.domain.core.validation;

import com.dto.AddUserRequest;

/* То, что должно быть у каждого правила валидаци */
public interface ValidationRule {

    org.junit.jupiter.api.function.Executable validate(AddUserRequest request);

    /* Чтобы всегда перед запуском правила валидации запрос проверялся на null */
    default void checkNotNull(AddUserRequest entity) {
        if (entity == null) {
            throw new ValidationException("ToDo must not be null.");
        }
    }
}

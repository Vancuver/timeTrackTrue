package com.domain.core.validation;

import com.dto.AddUserRequest;
import org.springframework.stereotype.Component;

@Component
public class ToDoNameNullValidationRule implements ValidationRule {

    @Override
    public org.junit.jupiter.api.function.Executable validate(AddUserRequest request) {
        if (request.getName() == null) {
            throw new ValidationException("ToDo name must be not null");
        }
        return null;
    }
}

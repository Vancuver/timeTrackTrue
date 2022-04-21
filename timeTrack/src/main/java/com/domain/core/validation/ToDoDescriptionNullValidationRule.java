package com.domain.core.validation;

import com.dto.AddUserRequest;
import org.springframework.stereotype.Component;

@Component
public class ToDoDescriptionNullValidationRule implements ValidationRule {
    @Override
    public org.junit.jupiter.api.function.Executable validate(AddUserRequest request) {
        if (request.getDescription() == null) {
            throw new ValidationException("ToDo description must not be null");
        }
        return null;
    }
}

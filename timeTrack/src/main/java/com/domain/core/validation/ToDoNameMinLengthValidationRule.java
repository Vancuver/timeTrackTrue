package com.domain.core.validation;

import com.dto.AddUserRequest;
import org.springframework.stereotype.Component;

@Component
public class ToDoNameMinLengthValidationRule implements ValidationRule {
    @Override
    public org.junit.jupiter.api.function.Executable validate(AddUserRequest request) {
        if (request.getName().length() < 3) {
            throw new ValidationException("ToDo name length must be greater than 3 but actual name length is "
                    + request.getName().length());
        }
        return null;
    }
}

package com.domain.core.validation;

import com.dto.AddUserRequest;
import org.springframework.stereotype.Component;

@Component
public class ToDoNameMaxLengthValidationRule implements ValidationRule {
    @Override
    public org.junit.jupiter.api.function.Executable validate(AddUserRequest request) {
        if (request.getName().length() > 10) {
            throw new ValidationException("ToDo name length must be less than 10 but actual name length is "
                    + request.getName().length());
        }
        return null;
    }
}

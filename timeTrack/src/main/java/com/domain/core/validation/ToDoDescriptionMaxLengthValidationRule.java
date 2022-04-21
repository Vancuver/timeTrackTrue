package com.domain.core.validation;

import com.dto.AddUserRequest;
import org.springframework.stereotype.Component;

@Component
public class ToDoDescriptionMaxLengthValidationRule implements ValidationRule {
    @Override
    public org.junit.jupiter.api.function.Executable validate(AddUserRequest request) {
        if (request.getDescription().length() > 10) {
            throw new ValidationException("ToDo description length must be less than 10 but actual description length is "
                    + request.getName().length());
        }
        return null;
    }
}

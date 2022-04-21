package com.domain.core.validation;

import com.dto.AddUserRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
/* Сервис валидации */
public class ValidationService {

    /* Зависит от списка правил валидации */
    private final List<ValidationRule> validationRules;

    /* Переданные правила, будут правилами этого сервиса */
    public ValidationService(List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
    }


    public List<CoreError> validate(AddUserRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request == null) {
            errors.add(new CoreError("ToDo must not be null"));
            return errors;
        }

        return validationRules.stream()
                .map(rule -> mapError(rule, request))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private CoreError mapError(ValidationRule rule, AddUserRequest entity) {
        try {
            rule.validate(entity);
        } catch (ValidationException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }

}

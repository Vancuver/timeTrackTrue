package core;

import core.validation.CoreError;
import core.validation.ValidationRule;
import core.validation.ValidationService;
import dto.AddUserRequest;

import java.util.List;

class MockValidationService extends ValidationService {
    public MockValidationService(List<ValidationRule> validationRules) {
        super(validationRules);
    }

    @Override
    public List<CoreError> validate(AddUserRequest request) {
        //mock
        return List.of();
    }
}

package Core.Validation;

import dto.AddUserRequest;

public class NameAndSurnameNullValidationRule implements ValidationRule{
    @Override
    public void validate(AddUserRequest entity) {
        if (entity.getName() == null){
            throw  new ValidationException("User name must not be null");
        }
        if (entity.getSurname() == null){
            throw  new ValidationException("User surname must not be null");
        }
        }
    }


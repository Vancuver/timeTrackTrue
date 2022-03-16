package Core.Validation;

import dto.AddUserRequest;

public class NameAndSurnameMinLengthValidationRule implements ValidationRule{
    @Override
    public void validate(AddUserRequest entity) {
        if (entity.getName().length()< 3){
            throw new ValidationException("Name need to be more than 3 symbols");
        }
        if (entity.getSurname().length()< 3){
            throw new ValidationException("Surname need to be more than 3 symbols");
        }
    }
}

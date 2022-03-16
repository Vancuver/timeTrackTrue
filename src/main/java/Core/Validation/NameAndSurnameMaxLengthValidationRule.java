package Core.Validation;

import dto.AddUserRequest;

public class NameAndSurnameMaxLengthValidationRule implements ValidationRule{
    @Override
    public void validate(AddUserRequest entity) {
        if (entity.getName().length()> 12){
            throw new ValidationException("Name need to be less than 12 symbols");
        }
        if (entity.getSurname().length()> 12){
            throw new ValidationException("Surname need to be less than 12 symbols");
        }
    }
}

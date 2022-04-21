package core.validation;

import dto.AddUserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ToDoNameMaxLengthValidationRuleTest {

    private ToDoNameMaxLengthValidationRule validationRule = new ToDoNameMaxLengthValidationRule();


    @Test
    void failed(){

        var request = new AddUserRequest();
        request.setName("Teeeeeeeeeeeeeeeeeeeeeeest");
        Assertions.assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }

    @Test
    void  passed(){

        var request = new AddUserRequest();
        request.setName("Teeeeest");
        Assertions.assertDoesNotThrow(() -> validationRule.validate(request));
    }


}
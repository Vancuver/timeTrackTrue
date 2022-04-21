package core.validation;

import dto.AddUserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ToDoNameMinLengthValidationRuleTest {


   private ToDoNameMinLengthValidationRule validationRule = new ToDoNameMinLengthValidationRule();




    @Test
    void failed() {

        var request = new AddUserRequest();
        request.setName("tt");
        Assertions.assertThrows(ValidationException.class, () -> validationRule.validate(request));

    }
    @Test
    void passed(){

        var request = new AddUserRequest();
        request.setName("ttttt");
        Assertions.assertDoesNotThrow(() -> validationRule.validate(request));

    }
}
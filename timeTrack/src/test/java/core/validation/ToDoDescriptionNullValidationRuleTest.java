package core.validation;

import dto.AddUserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ToDoDescriptionNullValidationRuleTest {

    ToDoDescriptionNullValidationRule validationRule = new ToDoDescriptionNullValidationRule();

    @Test
    void failed(){
        var request = new AddUserRequest();
        Assertions.assertThrows(ValidationException.class,() -> validationRule.validate(request));
    }

    @Test
    void passed(){
        var request = new AddUserRequest();
        request.setDescription("Test");
        Assertions.assertDoesNotThrow(() -> validationRule.validate(request));

    }
}
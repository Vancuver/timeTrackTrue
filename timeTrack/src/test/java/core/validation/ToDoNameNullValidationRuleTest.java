package core.validation;

import dto.AddUserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ToDoNameNullValidationRuleTest {



ToDoNameNullValidationRule validationRule = new ToDoNameNullValidationRule();



    @Test
    void shouldShowExceptionWhenNameNull(){
        var request = new AddUserRequest();
        Assertions.assertThrows(ValidationException.class, () -> validationRule.validate(request));

    }
    @Test
    void shouldNotShowExceptionWhenNameNull(){
        var request = new AddUserRequest();
        request.setName("Test");
        Assertions.assertDoesNotThrow(() -> validationRule.validate(request));
    }


}
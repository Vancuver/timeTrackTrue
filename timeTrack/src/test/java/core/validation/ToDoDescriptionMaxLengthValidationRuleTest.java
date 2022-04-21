package core.validation;

import dto.AddUserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ToDoDescriptionMaxLengthValidationRuleTest {

    ToDoDescriptionMaxLengthValidationRule validationRule = new ToDoDescriptionMaxLengthValidationRule();

    @Test
    void failed(){
        var request = new AddUserRequest();
        request.setName("Test");
        request.setDescription("Teeeeeeeeeeeeeeeest");
        Assertions.assertThrows(ValidationException.class, () -> validationRule.validate(request));
    }
    @Test
    void passed(){
        var request = new AddUserRequest();
        request.setDescription("Teeest");
        Assertions.assertDoesNotThrow(() -> validationRule.validate(request));
    }

}
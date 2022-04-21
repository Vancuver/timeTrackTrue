package core.validation;

import dto.AddUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ValidationServiceTest {

    @Mock
    private ValidationRule validationRule;

    @Captor
    private ArgumentCaptor<AddUserRequest> captor;

    private ValidationService validationService;


    @BeforeEach
    void setUp(){
        validationService = new ValidationService(List.of(validationRule));
    }

    @Test
    void shouldMapErrors(){
        doThrow( new ValidationException("Test")).when(validationRule).validate(any());
        var request = new AddUserRequest();
        var actual = validationService.validate(request);


        verify(validationRule).validate(captor.capture());
        var capturedRequest = captor.getValue();




        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(actual.get(0), new CoreError("Test"));
    }




}
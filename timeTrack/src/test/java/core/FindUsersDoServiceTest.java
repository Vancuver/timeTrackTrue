package core;

import com.domain.UserEntity;
import com.domain.core.FindUsersDoService;
import com.dto.FindAllUsersResponse;
import com.dto.UserDTO;
import com.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindUsersDoServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private FindUsersDoService findUsersDoService;


    /* Должен найти все  */
    @Test
    void shouldFindAllUsers() {
        var returnResult = entities();                          /* Создаём тестовые сущности */
        when(repository.findAll()).thenReturn(returnResult);                  /* Когда вызывается метод findall показывать тестовые сущности */

        /* Реальный результат */
        var result = findUsersDoService.findAll();

        /* Ожидаемый результат */
        var expectedResult = response();

        /* Сравниваем */
        assertEquals(expectedResult, result);
    }

    /* Создаём список тестовых сущностей */
    private List<UserEntity> entities() {
        var returnEntity = new UserEntity();
        returnEntity.setId(1);
        returnEntity.setDescription("Test description");
        returnEntity.setName("Test Name");
        return List.of(returnEntity);
    }

    /* Создаём ответ на тестовый запрос юзера */
    private FindAllUsersResponse response() {
        var dto = new UserDTO(1, "Test Name", "Test description");
        return new FindAllUsersResponse(List.of(dto));
    }
}
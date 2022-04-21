package core;

import com.domain.UserEntity;
import com.domain.core.AddUsersService;
import com.domain.core.validation.CoreError;
import com.domain.core.validation.ValidationService;
import com.dto.AddUserRequest;
import com.dto.AddUserResponse;
import com.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static core.TestDtoFactory.createRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/* Обозначаем Мокито */
@ExtendWith(MockitoExtension.class)
class AddUsersServiceTest {

    /* Заглушка */
    @Mock
    private UserRepository repository;

    /* Заглушка */
    @Mock
    private ValidationService validationService;

    /* Подключение заглушек */
    @InjectMocks
    private AddUsersService addUsersService;

    /* Сами тесты */

    /* Когда нет ошибок валидации */
    @Test
    void shouldSuccessfullySaveToDo() {

        AddUserRequest request = createRequest();                               /* Создание запроса */
        when(validationService.validate(request)).thenReturn(List.of());           /* Проэцируем ситуацию, когда валидация пройдена успешно */
        when(repository.save(entity(null))).thenReturn(entity(1001));       /* Делаем так, чтобы у сущности было айди */

        /* Это наш реальный результат */
        var result = addUsersService.add(request);                  /* Отправляем запрос в сервис */

        verify(repository).save(any());                                            /* Обозначает что можно сохранять любую сущность */
        verify(validationService).validate(any());                                 /* Обозначаем что валидация проверяет любую сущность */

        /* Это результат который мы ожидаем */
        var expected = new AddUserResponse();                                      /* Создаём ответ на запрос юзера */
        expected.setErrors(null);                                                  /* Устанавливаем что ошибок нет */
        expected.setCreatedToDoId(1001);                                           /* Айди ставим на 1001 */

        /* Сравнение ожидаемого и реального результата */
        assertEquals(expected, result);
    }


    /* Когда есть ошибки валидации */
    @Test
    void shouldReturnErrors() {
        AddUserRequest request = createRequest();                                /* Создаём запрос */
        when(validationService.validate(request))                                   /* Валидация возвращает ошибку */
                .thenReturn(List.of(new CoreError("TEST ERROR")));


        /* Это наш реальный результат */
        var result = addUsersService.add(request);                   /* Отправляем запрос в сервис */

        verify(validationService).validate(any());                                  /* Валидация проверяет любую сущность */
        verifyNoInteractions(repository);                                           /* Репозиторий не вызывается */


        /* Это наш ожидаемый результат */
        var expected = new AddUserResponse();                                       /* Создание ответа на запрос юзера */
        expected.setErrors(List.of(new CoreError("TEST ERROR")));                   /* Устанавливаем ошибку */
        expected.setCreatedToDoId(null);                                            /* Айди ставим на нулл */

        /* Сравниваем */
        assertEquals(expected, result);
    }

    /* Создаём тестовую сущность */
    private UserEntity entity(Integer id) {
        var entity =  new UserEntity();
        entity.setId(id);
        entity.setName("TEST_NAME");
        entity.setDescription("TEST_DESCRIPTION");
        return entity;
    }
}
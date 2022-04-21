package core;

import com.dto.AddUserRequest;

/* Класс создающий "запрос юзера" для теста */
class TestDtoFactory {

    /* Создание обычного запроса */
    public static AddUserRequest createRequest() {
        AddUserRequest request = new AddUserRequest();
        request.setName("TEST_NAME");
        request.setDescription("TEST_DESCRIPTION");
        return request;
    }

    /* Создание запроса без имени */
    public static AddUserRequest createRequestWithoutName() {
        var request = new AddUserRequest();
        request.setDescription("TEST_DESCRIPTION");
        return request;
    }

    /* Создание запроса без пояснения */
    public static AddUserRequest createRequestWithoutDescription() {
        var request = new AddUserRequest();
        request.setName("TEST_NAME");
        return request;
    }
}

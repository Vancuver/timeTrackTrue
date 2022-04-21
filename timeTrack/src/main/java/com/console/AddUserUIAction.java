package com.console;

import com.domain.core.AddUsersService;
import com.dto.AddUserRequest;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Order(2)
@Component
/* Класс действия добавления пользователя в список */
public class AddUserUIAction implements UIAction {

    /* зависимость от сервиса */
    private final AddUsersService addTaskService;

    /* Указываем что задание переданное сервисом, будет являться заданием этого класса */
    public AddUserUIAction(AddUsersService addTaskService) {
        this.addTaskService = addTaskService;
    }

    @Override
    /* Метод реализации добавления пользователя в список */
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter user name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter user description: ");
        String description = scanner.nextLine();

        /* Создаём запрос на добавление пользователя */
        var request = new AddUserRequest();
        request.setName(name);
        request.setDescription(description);

        /* Создаём ответ на запрос на добавление пользователя */
        var response = addTaskService.add(request);
        /* Показывает ответ на запрос */
        System.out.println("Received response: " + response);
    }

    /* Получение имени действия, нужно для использования в перечислении в меню */
    @Override
    public String getActionName() {
        return "Add User";
    }
}

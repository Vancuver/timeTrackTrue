package com.console;

import com.domain.core.FindUsersDoService;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

@Order(4)
@Component
public class FindAllUsersUIAction implements UIAction {

    /* Вписываем зависимость от сервиса */
    private final FindUsersDoService findUsersDoService;

    /* Всё что передано сервисом, относится к этому классу */
    public FindAllUsersUIAction(FindUsersDoService findUsersDoService) {
        this.findUsersDoService = findUsersDoService;
    }

    @Override
    /* Метод реализации показа всех зарегистрированных пользователей */
    public void execute() {
        var response = findUsersDoService.findAll();
        System.out.println(response);
    }

    @Override
    public String getActionName() {
        return "Find All";
    }
}

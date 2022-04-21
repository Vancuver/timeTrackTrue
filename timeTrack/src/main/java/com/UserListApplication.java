package com;

import com.config.AppConfig;
import com.console.UIMenu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserListApplication {

    public static void main(String[] args) {
//        /* Создаём хранилище данных */
//        var repository = new ArrayListUserRepository();
//        /* Создаём правила валидации, состоящие из списка правил */
//        var validationRules = List.of(
//                new ToDoNameNullValidationRule(),
//                new ToDoNameMinLengthValidationRule(),
//                new ToDoNameMaxLengthValidationRule(),
//                new ToDoDescriptionNullValidationRule(),
//                new ToDoDescriptionMaxLengthValidationRule()
//        );
//        /* Создаём сервис, который будет управлять валидацией */
//        var validationService = new ValidationService(validationRules);
//
//        /* Создаём сервис для управления добавлением пользователя */
//        var addService = new AddUsersService(repository, validationService);
//        /* Создаём сервис для управления показом всех зарегистрированных пользователей */
//        var findAllService = new FindUsersDoService(repository);
//
//        /* Создаём список возможных для пользователя действий */
//        var actions = Arrays.asList(
//                new AddUserUIAction(addService),
//                new FindAllUsersUIAction(findAllService)
//        );
//
//        /* Создаём меню */
//        var uiMenu = new UIMenu(actions);
//        /* Запускаем меню */
//        uiMenu.startUI();
        try {


            var context = new AnnotationConfigApplicationContext(AppConfig.class);
            var uiMenu = context.getBean(UIMenu.class);
            uiMenu.startUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
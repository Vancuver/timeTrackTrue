package com.console;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UIMenu {

    /* Зависимость от переданного списка действий */
    private final List<UIAction> uiActions;


    /* Конструктор меню, в котором мы указываем что переданные действия в параметрах, это действия самого меню */
    public UIMenu(List<UIAction> uiActions) {
        this.uiActions = uiActions;
    }

    /* Метод запуска программы */
    public void startUI() {
        /* бесконечный цикл */
        while (true) {
            try {
                System.out.println("Please make your choice: ");                    /*  информация для пользователя */
                for (int i = 0; i < uiActions.size(); i++) {                        /* Цикл выведения всех действий */
                    var uiAction = uiActions.get(i);
                    System.out.println(i + ". " + uiAction.getActionName());
                }
                Scanner scanner = new Scanner(System.in);
                int userInput = scanner.nextInt();

                /* Запуск метода реализации пункта из списка, который выбрал пользователь */
                uiActions.get(userInput).execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

package UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UIMenu { //Задача предоставить меню пользователю

    private final List<UIAction> uiActions; //Создание списка UI действий

    public UIMenu(List<UIAction> uiActions){
        this.uiActions = uiActions;
    } //переданный список действий, станет списком пунктов для меню

    public void startUI(){  //Запуск интерфейса
        while(true){
            try {
                System.out.println("Please make your choice: ");
                for (int i = 0; i < uiActions.size(); i++) { //Вывод меню
                    var uiAction = uiActions.get(i); //Получение действия из списка
                    System.out.println(i + ". " + uiAction.getActionName());//Получение названия действия из списка
                }
                Scanner scanner = new Scanner(System.in);
                int userInput = scanner.nextInt();//получение номера действия пользователя

                uiActions.get(userInput).execute(); //запуск нужного действия
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

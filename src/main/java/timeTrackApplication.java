import Core.AddUserService;
import Core.FindAllUsersService;
import Core.ValidationService;
import DataBase.ArrayListTimeTrackRepository;
import UI.AddUserUIAction;
import UI.FindAllUsersUIAction;
import UI.UIMenu;

import java.util.Arrays;

public class timeTrackApplication {

    public static void main(String[] args) {

        var repository = new ArrayListTimeTrackRepository(); // Создаём объект репозитория(места откуда берём инфу)
        var validationService = new ValidationService();

        var addService = new AddUserService(repository, validationService); //Создаем сервис отвечающий за добавление юзеров
        var findAllService = new FindAllUsersService(repository); //Создаем сервис отвечающий за выведение всех юзеров

        var actions = Arrays.asList(new AddUserUIAction(addService),
                 new FindAllUsersUIAction(findAllService)); //Создаём массив как список действий из переданных параметров


        UIMenu uiMenu = new UIMenu(actions); //создаём объект меню, передавая действия как параметр
        uiMenu.startUI(); //запуск меню
    }
}
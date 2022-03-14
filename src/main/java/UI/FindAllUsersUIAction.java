package UI;

import Core.FindAllUsersService;

public class FindAllUsersUIAction implements UIAction{

    private final FindAllUsersService findAllUsersService; //привязываем сервис нахождения к действию нахождения юзера

    public FindAllUsersUIAction(FindAllUsersService findAllUsersService) {
        this.findAllUsersService = findAllUsersService; //Обозначаем что переданный сервис будет сервисом для нашего действия
    }

    @Override
    public void execute() {

        findAllUsersService.findAll().forEach(System.out::println);

    } //Показываем всех юзеров

    @Override
    public String getActionName() {
        return "Find all users";
    } //Выведение названия действия в список
}

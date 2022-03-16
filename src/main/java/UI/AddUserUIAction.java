package UI;

import Core.AddUserService;
import Domain.timeTrackEntity;
import dto.AddUserRequest;

import java.util.Scanner;

public class AddUserUIAction implements UIAction {

    private final AddUserService addUserService; //привязываем сервис добавления к действию добавления юзера

    public AddUserUIAction(AddUserService addUserService) {
        this.addUserService = addUserService; //Обозначаем что переданный сервис будет сервисом для нашего действия
    }


    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter user name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter user surname: ");
        String surname = scanner.nextLine();


        var request = new AddUserRequest();
        request.setName(name);
        request.setSurname(surname);

        var response = addUserService.addUser(request);
        System.out.println("Received response: " + response);

    }

    @Override
    public String getActionName() {
        return "Add User";
    } //Выведение названия действия в список


}

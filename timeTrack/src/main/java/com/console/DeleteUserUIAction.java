package com.console;

import com.domain.core.DeleteUserService;
import com.domain.core.GetUserByIDService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DeleteUserUIAction implements UIAction {

    private final DeleteUserService deleteUserService;
    private final GetUserByIDService getUserByIDService;

    public DeleteUserUIAction(DeleteUserService deleteUserService, GetUserByIDService getUserByIDService) {
        this.deleteUserService = deleteUserService;
        this.getUserByIDService = getUserByIDService;
    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter User id: ");
        var id = Integer.valueOf(scanner.nextLine());
        var foundUserResponse = getUserByIDService.getById(id);
        var user = foundUserResponse.getUser();




        deleteUserService.delete(user);

    }

    @Override
    public String getActionName() {
        return "Delete User";
    }
}

package com.console;

import com.domain.core.GetUserByIDService;
import com.domain.core.UpdateUserService;
import com.dto.UpdateUserRequest;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Order(3)
@Component
public class UpdateUserUIAction implements UIAction {

    private final UpdateUserService updateUserService;
    private final GetUserByIDService getUserByIDService;

    public UpdateUserUIAction(UpdateUserService updateUserService, GetUserByIDService getUserByIDService) {
        this.updateUserService = updateUserService;
        this.getUserByIDService = getUserByIDService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter User id: ");
        var id = Integer.valueOf(scanner.nextLine());
        var foundUserResponse = getUserByIDService.getById(id);
        var user = foundUserResponse.getUser();
        System.out.println("Please enter name: ");
        var name = scanner.nextLine();
        System.out.println("Please enter description: ");
        var description = scanner.nextLine();

        var updateRequest = new UpdateUserRequest();
        updateRequest.setId(user.getId());
        var updatedName = getUpdatedValue(name, user.getName()) ;
        var updatedDescription = getUpdatedValue(description, user.getDescription());

        updateRequest.setName(updatedName);
        updateRequest.setDescription(updatedDescription);

        updateUserService.update(updateRequest);
    }

    public String getUpdatedValue(String newValue, String oldValue) {
        return newValue.equals("") ? oldValue : newValue;
    }

    public String getUpdatedValueLegacy(String newValue, String oldValue) {
        if (newValue.equals("")) {
            return oldValue;
        } else {
            return newValue;
        }
    }

    @Override
    public String getActionName() {
        return "Update User";
    }
}

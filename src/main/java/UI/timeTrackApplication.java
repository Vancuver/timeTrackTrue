package UI;

import Core.timeTrackEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class timeTrackApplication {

    public static void main(String[] args) {

        var addService = new AddUserService();
        var actions = Arrays.asList(new AddUserUIAction(), new FindAllUsersUIAction())


        UIMenu uiMenu = new UIMenu();
        uiMenu.startUI();
    }
}
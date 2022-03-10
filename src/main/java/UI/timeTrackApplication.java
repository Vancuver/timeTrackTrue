package UI;

import java.util.Scanner;

public class timeTrackApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to Time Track!");
        System.out.println("Please make a choice:");


        Scanner scanner = new Scanner(System.in);
        var userInput = scanner.nextInt();

        System.out.println("1. Add");
        System.out.println("2. Get All");
        System.out.println("3. Delete");

        if(userInput == 1){
            System.out.println("Please add chef name");
            String name = scanner.nextLine();
            System.out.println("Please add chef surname");
            String surname = scanner.nextLine();
        }
    }
}

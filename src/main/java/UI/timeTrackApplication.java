package UI;

import Core.timeTrackEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class timeTrackApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to Time Track!");
        System.out.println("Please make a choice:");

        int chefSequenceId = 0;
        Map<Integer, timeTrackEntity> repository = new HashMap<>();

        while (true) {
            try{


            System.out.println("1. Add");
            System.out.println("2. Get All");
            System.out.println("3. Delete");

            var scanner = new Scanner(System.in);
            var userInput = Integer.parseInt(scanner.nextLine());

            if (userInput == 1) {
                System.out.println("Please add chef name");
                var name = scanner.nextLine();
                System.out.println("Please add chef surname");
                var surname = scanner.nextLine();
                var chef = new timeTrackEntity();
                chef.setName(name);
                chef.setSurname(surname);

                chef.setId(chefSequenceId);
                chefSequenceId++;

                repository.put(chef.getId(), chef);

            } else if (userInput == 2) {
                repository.entrySet().stream()
                        .map(Map.Entry::getValue)
                        .forEach(System.out::println);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}}
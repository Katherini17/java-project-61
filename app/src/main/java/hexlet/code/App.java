package hexlet.code;

import hexlet.code.games.EvenGame;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        var choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 0:
                break;
            case 1:
                var user = new User();
                Engine.greet(user);
                break;
            case 2:
                var evenGame = new EvenGame(scanner);
                evenGame.play();
                break;
            default:
                System.out.println("Incorrect choice");
        }

        scanner.close();

    }

}

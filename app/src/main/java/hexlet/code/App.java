package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        var choice = scanner.next();

        switch (choice) {
            case "0":
                break;
            case "1":
                Engine.sendWelcomeMessage();
                var name = Engine.askUserName(scanner);
                Engine.sendGreetingByNameMessage(name);
                break;
            case "2":
                EvenGame.play(scanner);
                break;
            case "3":
                CalcGame.play(scanner);
                break;
            case "4":
                GcdGame.play(scanner);
                break;
            case "5":
                ProgressionGame.play(scanner);
                break;
            default:
                System.out.println("Incorrect choice");
        }

        scanner.close();
    }

}

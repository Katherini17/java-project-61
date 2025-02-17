package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;


import java.util.Scanner;

public class App {

    private static final String GREET = "1";
    private static final String EVEN = "2";
    private static final String CALC = "3";
    private static final String GCD = "4";
    private static final String PROGRESSION = "5";
    private static final String PRIME = "6";
    private static final String EXIT = "0";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(GREET + " - Greet");
        System.out.println(EVEN + " - Even");
        System.out.println(CALC + " - Calc");
        System.out.println(GCD + " - GCD");
        System.out.println(PROGRESSION + " - Progression");
        System.out.println(PRIME + " - Prime");
        System.out.println(EXIT + " - Exit");
        System.out.print("Your choice: ");

        var choice = scanner.nextLine().trim();

        switch (choice) {
            case "0":
                break;
            case "1":
                Engine.sendWelcomeMessage();
                var name = Engine.askUserName(scanner);
                Engine.sendGreetingByNameMessage(name);
                break;
            case "2":
                EvenGame.playEvenGame(scanner);
                break;
            case "3":
                CalcGame.playCalcGame(scanner);
                break;
            case "4":
                GcdGame.playGcdGame(scanner);
                break;
            case "5":
                ProgressionGame.playProgressionGame(scanner);
                break;
            case "6":
                PrimeGame.playPrimeGame(scanner);
                break;
            default:
                System.out.println("Incorrect choice");
        }

        scanner.close();
    }
}

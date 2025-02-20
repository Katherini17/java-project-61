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
        System.out.print("""
            Please enter the game number and press Enter.
            1 - Greet
            2 - Even
            3 - Calc
            4 - GCD
            5 - Progression
            6 - Prime
            0 - Exit
            Your choice:\s""");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case EXIT:
                break;
            case GREET:
                Engine.greet();
                break;
            case EVEN:
                EvenGame.play(scanner);
                break;
            case CALC:
                CalcGame.play(scanner);
                break;
            case GCD:
                GcdGame.play(scanner);
                break;
            case PROGRESSION:
                ProgressionGame.play(scanner);
                break;
            case PRIME:
                PrimeGame.play(scanner);
                break;
            default:
                System.out.println("Incorrect choice");
        }

        scanner.close();
    }
}

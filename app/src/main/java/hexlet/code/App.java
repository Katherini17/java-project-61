package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Greeting.welcome;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        var choice = scanner.nextInt();

        switch (choice) {
            case 0:
                break;
            case 1:
                welcome();
                break;
            default:
                System.out.println("Incorrect choice");
        }

        scanner.close();

    }

}

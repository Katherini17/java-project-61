package hexlet.code;

import java.util.Scanner;

public class User {

    private String name;

    public void setName() {
        var scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        var userName = scanner.nextLine();
        this.name = userName;
    }

    public String getName() {
        return name;
    }

    public void sendWelcomMessag() {
        System.out.println("Welcome to the Brain Games!");
    }

    public void sendGreetingMessag() {
        System.out.println("Hello, " + name + "!");
    }

    public void tellCorrect() {
        System.out.println("Correct!");
    }

    public void tellIncorrect(String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + name + "!");
    }

    public void congratulate() {
        System.out.println("Congratulations, " + name + "!");
    }

}

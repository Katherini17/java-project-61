package hexlet.code;

import java.util.Scanner;

public class Engine {
    private String userName;

    public void setName() {
        this.userName = askUserName();
    }

    public String askUserName() {
        var scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        var userName = scanner.nextLine();

        return userName;
    }



    public String getName() {
        return userName;
    }

    public void sendWelcomMessag() {
        System.out.println("Welcome to the Brain Games!");
    }

    public void sendGreetingMessag() {
        System.out.println("Hello, " + userName + "!");
    }

    public void tellCorrect() {
        System.out.println("Correct!");
    }

    public void tellIncorrect(String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + userName + "!");
    }

    public void congratulate() {
        System.out.println("Congratulations, " + userName + "!");
    }

}
}

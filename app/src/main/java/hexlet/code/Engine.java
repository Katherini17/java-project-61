package hexlet.code;

import java.util.Scanner;

public class Engine {
    private String userName;
    private Scanner scanner;
    // Количество раундов в каждой игре
    private int roundsCount = 3;

    Engine(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setName() {
        this.userName = askUserName();
    }

    public String getName() {
        return userName;
    }

    public void setRoundsCount(int roundsCount) {
        this.roundsCount = roundsCount;
    }

    public int getRoundsCount() {
        return this.roundsCount;
    }

    // Методы для взаимодействия с пользователем

    public String askUserName() {
        System.out.print("May I have your na;me? ");
        var name = scanner.nextLine();

        return name;
    }
    public void sendWelcomMessage() {
        System.out.println("Welcome to the Brain Games!");
    }

    public void sendGreetingByNameMessage() {
        System.out.println("Hello, " + userName + "!");
    }

    public void sendCorrectMessage() {
        System.out.println("Correct!");
    }

    public void sendIncorrectMessage(String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + userName + "!");
    }

    public void congratulate() {
        System.out.println("Congratulations, " + userName + "!");
    }

    public void greetCompletely() {
        sendWelcomMessage();
        setName();
        sendGreetingByNameMessage();
    }

    // Логика игры





}


package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static int defaultRoundsCount = 3;

    // Методы для взаимодействия с пользователем

    public static String askUserName(Scanner scanner) {
        System.out.print("May I have your name? ");
        var name = scanner.nextLine();
        return name;
    }
    public static void sendWelcomeMessage() {
        System.out.println("Welcome to the Brain Games!");
    }

    public static void sendGreetingByNameMessage(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void sendCorrectMessage() {
        System.out.println("Correct!");
    }

    public static void sendIncorrectMessage(String name, String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + name + "!");
    }

    public static void congratulate(String name) {
        System.out.println("Congratulations, " + name + "!");
    }

    public static void askUser(String question) {
        System.out.println("Question: " + question);
    }

    public static String getUserAnswer(Scanner scanner) {
        return scanner.nextLine();
    }

    public static boolean checkAnswer(String userAnswer, String correctAnswer) {
        return userAnswer.equals(correctAnswer);
    }

    // Логика игры

    public static void printResult(String userAnswer, String correctAnswer, boolean isCorrectAnswer, String userName) {

        if (isCorrectAnswer) {

            sendCorrectMessage();

        } else {

            sendIncorrectMessage(userName, userAnswer, correctAnswer);

        }
    }

    public static int generateRandomNumber(int limit) {
        return (int) (Math.random() * limit) + 1;
    }
}


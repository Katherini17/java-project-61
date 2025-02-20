package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final Integer DEFAULT_ROUNDS_COUNT = 3;

    public static void play(Scanner scanner, String task, String[] questions, String[] correctAnswers) {
        sendWelcomeMessage();
        var userName = askUserName(scanner);
        sendGreetingByNameMessage(userName);

        Engine.printTask(task);

        for (int i = 0; i < DEFAULT_ROUNDS_COUNT; i++) {

            var question = questions[i];
            var correctAnswer = correctAnswers[i];

            askUser(question);
            var userAnswer = getUserAnswer(scanner);

            var isCorrectAnswer = checkAnswer(userAnswer, correctAnswer);

            if (isCorrectAnswer) {
                sendCorrectMessage();
            } else {
                sendIncorrectMessage(userName, userAnswer, correctAnswer);
            }

            var isFinalRound = i == DEFAULT_ROUNDS_COUNT - 1;
            if (!isCorrectAnswer) {
                return;
            }
            if (isFinalRound) {
                congratulate(userName);
            }
        }

    }

    public static String askUserName(Scanner scanner) {
        System.out.print("May I have your name? ");
        var name = scanner.nextLine();
        return name;
    }
    public static void sendWelcomeMessage() {
        System.out.println();
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

    public static void printTask(String task) {
        System.out.println(task);
    }

    public static String getUserAnswer(Scanner scanner) {
        System.out.print("Your answer: ");
        return scanner.nextLine();
    }

    public static boolean checkAnswer(String userAnswer, String correctAnswer) {
        return userAnswer.equals(correctAnswer);
    }

    public static int generateRandomNumber(int limit) {
        return (int) (Math.random() * limit) + 1;
    }

    public static int generateElementInRange(int min, int max) {
        var range = max - min + 1;
        return Engine.generateRandomNumber(range) + (max - range);
    }

}



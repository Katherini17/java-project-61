package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final Integer DEFAULT_ROUNDS_COUNT = 3;

    public static void runGame(String task, String[][] data) {
        sendWelcomeMessage();
        String userName = askUserName();
        sendGreetingByNameMessage(userName);

        Engine.printTask(task);

        for (int i = 0; i < DEFAULT_ROUNDS_COUNT; i++) {

            String question = data[0][i];
            String correctAnswer = data[1][i];

            askUser(question);
            String userAnswer = getUserAnswer();

            if (checkAnswer(userAnswer, correctAnswer)) {
                sendCorrectMessage();
            } else {
                sendIncorrectMessage(userName, userAnswer, correctAnswer);
                return;
            };

            if (i == DEFAULT_ROUNDS_COUNT - 1) {
                congratulate(userName);
            }
        }

    }

    public static String askUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        return name;
    }
    public static void sendWelcomeMessage() {
        System.out.println();
        System.out.println("Welcome to the Brain Games!");
    }

    public static void sendGreetingByNameMessage(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void greet() {
        Engine.sendWelcomeMessage();
        String name = Engine.askUserName();
        Engine.sendGreetingByNameMessage(name);
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

    public static String getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        return scanner.nextLine();
    }

    public static boolean checkAnswer(String userAnswer, String correctAnswer) {
        return userAnswer.equals(correctAnswer);
    }

}



package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class PrimeGame {

    public static final Integer MAX_RANDOM_NUMBER = 53;
    public static final String TASK = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void play(Scanner scanner) {
        var questions = new String[Engine.DEFAULT_ROUNDS_COUNT];
        var correctAnswers = new String[Engine.DEFAULT_ROUNDS_COUNT];

        for (int i = 0; i < Engine.DEFAULT_ROUNDS_COUNT; i++) {
            var randomNumber = Engine.generateRandomNumber(MAX_RANDOM_NUMBER);

            var correctAnswer = isPrimeNumber(randomNumber) ? "yes" : "no";
            correctAnswers[i] = correctAnswer;

            var question = Integer.toString(randomNumber);
            questions[i] = question;
        }

        Engine.runGame(scanner, TASK, questions, correctAnswers);
    }

    public static boolean isPrimeNumber(int number) {

        if (number == 1) {
            return false;
        }

        var rootOfNumber = (int) Math.sqrt(number);
        for (int i = 2; i <= rootOfNumber; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}

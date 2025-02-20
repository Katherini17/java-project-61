package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class EvenGame {

    public static final Integer MAX_RANDOM_NUMBER = 1000;
    public static final String TASK = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void play(Scanner scanner) {
        var questions = new String[Engine.DEFAULT_ROUNDS_COUNT];
        var correctAnswers = new String[Engine.DEFAULT_ROUNDS_COUNT];

        for (int i = 0; i < Engine.DEFAULT_ROUNDS_COUNT; i++) {

            var randomNumber = Engine.generateRandomNumber(MAX_RANDOM_NUMBER);
            questions[i] = Integer.toString(randomNumber);
            var correctAnswer = isEven(randomNumber) ? "yes" : "no";
            correctAnswers[i] = correctAnswer;

        }

        Engine.runGame(scanner, TASK, questions, correctAnswers);

    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

}

package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class GcdGame {
    public static final Integer MAX_RANDOM_NUMBER = 30;
    public static final String TASK = "Find the greatest common divisor of given numbers.";

    public static void playGcdGame(Scanner scanner) {
        var questions = new String[Engine.DEFAULT_ROUNDS_COUNT];
        var correctAnswers = new String[Engine.DEFAULT_ROUNDS_COUNT];

        for (int i = 0; i < Engine.DEFAULT_ROUNDS_COUNT; i++) {
            var number1 = Engine.generateRandomNumber(MAX_RANDOM_NUMBER);
            var number2 = Engine.generateRandomNumber(MAX_RANDOM_NUMBER);

            var correctAnswer = Integer.toString(calcGCD(number1, number2));
            correctAnswers[i] = correctAnswer;

            var question = number1 + " " + number2;
            questions[i] = question;
        }

        Engine.play(scanner, TASK, questions, correctAnswers);
    }

    public static int calcGCD(int number1, int number2) {
        var maxNumber = Math.max(number1, number2);
        var minNumber = Math.min(number1, number2);

        while (minNumber != 0) {
            var remainder = maxNumber % minNumber;
            maxNumber = minNumber;
            minNumber = remainder;
        }

        return maxNumber;
    }
}

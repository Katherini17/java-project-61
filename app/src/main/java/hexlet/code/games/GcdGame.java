package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class GcdGame {
    public static final Integer MAX_RANDOM_NUMBER = 30;
    public static final String TASK = "Find the greatest common divisor of given numbers.";

    public static void play(Scanner scanner) {
        String[][] data = new String[2][Engine.DEFAULT_ROUNDS_COUNT];

        for (int i = 0; i < Engine.DEFAULT_ROUNDS_COUNT; i++) {
            int number1 = Engine.generateRandomNumber(MAX_RANDOM_NUMBER);
            int number2 = Engine.generateRandomNumber(MAX_RANDOM_NUMBER);

            String question = number1 + " " + number2;
            data[0][i] = question;

            String correctAnswer = Integer.toString(calcGCD(number1, number2));
            data[1][i] = correctAnswer;

        }

        Engine.runGame(scanner, TASK, data);
    }

    public static int calcGCD(int number1, int number2) {
        int maxNumber = Math.max(number1, number2);
        int minNumber = Math.min(number1, number2);

        while (minNumber != 0) {
            int remainder = maxNumber % minNumber;
            maxNumber = minNumber;
            minNumber = remainder;
        }

        return maxNumber;
    }
}

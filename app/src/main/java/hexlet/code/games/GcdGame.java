package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class GcdGame {
    public static final Integer MAX_RANDOM_NUMBER = 30;
    public static final String TASK = "Find the greatest common divisor of given numbers.";

    public static void play() {
        String[][] data = generateData();
        Engine.runGame(TASK, data);
    }

    public static String[][] generateData() {
        Random random = new Random();

        String[][] data = new String[2][Engine.DEFAULT_ROUNDS_COUNT];

        for (int i = 0; i < Engine.DEFAULT_ROUNDS_COUNT; i++) {
            int number1 = random.nextInt(MAX_RANDOM_NUMBER) + 1;
            int number2 = random.nextInt(MAX_RANDOM_NUMBER) + 1;

            String question = number1 + " " + number2;
            data[0][i] = question;

            String correctAnswer = Integer.toString(calcGCD(number1, number2));
            data[1][i] = correctAnswer;
        }

        return data;
    }

    public static int calcGCD(int number1, int number2) {
        int maxNumber = Math.max(number1, number2);
        int minNumber = Math.min(number1, number2);

        int remainder = maxNumber % minNumber;

        if (remainder == 0) {
            return minNumber;
        }
        return calcGCD(minNumber, remainder);
    }
}

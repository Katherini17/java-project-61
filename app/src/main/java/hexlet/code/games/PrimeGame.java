package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class PrimeGame {

    public static final Integer MAX_RANDOM_NUMBER = 53;
    public static final String TASK = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void play() {
        Random random = new Random();

        String[][] data = new String[2][Engine.DEFAULT_ROUNDS_COUNT];

        for (int i = 0; i < Engine.DEFAULT_ROUNDS_COUNT; i++) {
            int randomNumber = random.nextInt(MAX_RANDOM_NUMBER) + 1;

            String question = Integer.toString(randomNumber);
            data[0][i] = question;

            String correctAnswer = isPrimeNumber(randomNumber) ? "yes" : "no";
            data[1][i] = correctAnswer;

        }

        Engine.runGame(TASK, data);
    }

    public static boolean isPrimeNumber(int number) {

        if (number == 1) {
            return false;
        }

        int rootOfNumber = (int) Math.sqrt(number);
        for (int i = 2; i <= rootOfNumber; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}

package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class EvenGame {

    public static final Integer MAX_RANDOM_NUMBER = 1000;
    public static final String TASK = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void play() {
        Random random = new Random();

        String[][] data = new String[2][Engine.DEFAULT_ROUNDS_COUNT];

        for (int i = 0; i < Engine.DEFAULT_ROUNDS_COUNT; i++) {
            int randomNumber = random.nextInt(MAX_RANDOM_NUMBER) + 1;
            data[0][i] = Integer.toString(randomNumber);

            String correctAnswer = isEven(randomNumber) ? "yes" : "no";
            data[1][i] = correctAnswer;

        }

        Engine.runGame(TASK, data);

    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

}

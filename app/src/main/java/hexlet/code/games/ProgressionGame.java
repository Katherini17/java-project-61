package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtil;

import java.util.Random;

public class ProgressionGame {
    public static final String TASK = "What number is missing in the progression?";

    public static final Integer MIN_COMMON_DIFFERENCE = 3;
    public static final Integer MAX_COMMON_DIFFERENCE = 25;

    public static final Integer MIN_FIRST_ELEMENT = 5;
    public static final Integer MAX_FIRST_ELEMENT = 70;

    public static final Integer MIN_PROGRESSION_LENGTH = 5;
    public static final Integer MAX_PROGRESSION_LENGTH = 10;

    public static void play() {
        Random random = new Random();

        String[][] data = new String[2][Engine.DEFAULT_ROUNDS_COUNT];

        for (int i = 0; i < Engine.DEFAULT_ROUNDS_COUNT; i++) {

            int length = RandomUtil.generateElementInRange(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
            int commonDifference = RandomUtil.generateElementInRange(MIN_COMMON_DIFFERENCE, MAX_COMMON_DIFFERENCE);
            int firstElement = RandomUtil.generateElementInRange(MIN_FIRST_ELEMENT, MAX_FIRST_ELEMENT);

            int positionOfHiddenElement = random.nextInt(length);

            String[] elements = getArithmeticProgression(length, firstElement, commonDifference);

            String correctHiddenElement = elements[positionOfHiddenElement];
            data[1][i] = correctHiddenElement;

            elements[positionOfHiddenElement] = "..";
            String question = String.join(" ", elements);
            data[0][i] = question;
        }

        Engine.runGame(TASK, data);
    }

    public static String[] getArithmeticProgression(int length, int firstElement, int commonDifference) {
        String[] elements = new String[length];
        int nextElement = firstElement;
        for (int i = 0; i < length; i++) {
            elements[i] = Integer.toString(nextElement);
            nextElement += commonDifference;
        }
        return elements;
    }

}

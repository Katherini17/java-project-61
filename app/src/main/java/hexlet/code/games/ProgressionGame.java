package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class ProgressionGame {
    public static final String TASK = "What number is missing in the progression?";

    public static final Integer MIN_COMMON_DIFFERENCE = 3;
    public static final Integer MAX_COMMON_DIFFERENCE = 25;

    public static final Integer MIN_FIRST_ELEMENT = 5;
    public static final Integer MAX_FIRST_ELEMENT = 70;

    public static final Integer MIN_PROGRESSION_LENGTH = 5;
    public static final Integer MAX_PROGRESSION_LENGTH = 10;

    public static void play(Scanner scanner) {
        String[][] data = new String[2][Engine.DEFAULT_ROUNDS_COUNT];

        for (int i = 0; i < Engine.DEFAULT_ROUNDS_COUNT; i++) {

            var length = Engine.generateElementInRange(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
            var commonDifference = Engine.generateElementInRange(MIN_COMMON_DIFFERENCE, MAX_COMMON_DIFFERENCE);
            var firstElement = Engine.generateElementInRange(MIN_FIRST_ELEMENT, MAX_FIRST_ELEMENT);

            var positionOfHiddenElement = Engine.generateRandomNumber(length) - 1;

            var elements = getArithmeticProgression(length, firstElement, commonDifference);

            var correctHiddenElement = elements[positionOfHiddenElement];
            data[1][i] = correctHiddenElement;

            elements[positionOfHiddenElement] = "..";
            String question = String.join(" ", elements);
            data[0][i] = question;
        }

        Engine.runGame(scanner, TASK, data);
    }

    public static String[] getArithmeticProgression(int length, int firstElement, int commonDifference) {
        var elements = new String[length];
        var nextElement = firstElement;
        for (int i = 0; i < length; i++) {
            elements[i] = Integer.toString(nextElement);
            nextElement += commonDifference;
        }
        return elements;
    }

}

package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class ProgressionGame {
    // Задаем максимальное и минимальное число элементов прогрессии
    // Каждый элемент арифметической прогрессии задается формулой:
    // an = a1 + (n - 1)*d,
    // где a1 - первый элемент арифметической прогрессии,
    //     d - разность арифметической прогрессии.
    public static final String TASK = "What number is missing in the progression?";
    // Пусть d будет случайным числом от 3 до 25
    public static final Integer MIN_COMMON_DIFFERENCE = 3;
    public static final Integer MAX_COMMON_DIFFERENCE = 25;
    // Задаем максимальный и минимальный возможный первый элемент арифметической прогрессии
    public static final Integer MIN_FIRST_ELEMENT = 5;
    public static final Integer MAX_FIRST_ELEMENT = 70;
    // Задаем минимальную и максимальную длину арифметической прогрессии
    public static final Integer MIN_PROGRESSION_LENGTH = 5;
    public static final Integer MAX_PROGRESSION_LENGTH = 10;

    public static void playProgressionGame(Scanner scanner) {
        var questions = new String[Engine.DEFAULT_ROUNDS_COUNT];
        var correctAnswers = new String[Engine.DEFAULT_ROUNDS_COUNT];

        for (int i = 0; i < Engine.DEFAULT_ROUNDS_COUNT; i++) {
            // Получаем длину арифметической прогрессии
            var length = Engine.generateElementInRange(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
            // Получаем разность арифметической прогрессии
            var commonDifference = Engine.generateElementInRange(MIN_COMMON_DIFFERENCE, MAX_COMMON_DIFFERENCE);
            // Получаем первый элемент арифметической прогрессии
            var firstElement = Engine.generateElementInRange(MIN_FIRST_ELEMENT, MAX_FIRST_ELEMENT);
            // Получаем позицию скрытого элемента арифметической прогрессии,
            var positionOfHiddenElement = Engine.generateRandomNumber(length) - 1;
            // Получаем массив - последовательность элементов арифметической
            var elements = getArithmeticProgression(length, firstElement, commonDifference);
            // Получаем правильный ответ - скрытый элемент арифметической прогрессии
            var correctHiddenElement = elements[positionOfHiddenElement];
            correctAnswers[i] = correctHiddenElement;
            // Скрываем элемент
            elements[positionOfHiddenElement] = "..";
            String question = String.join(" ", elements);
            questions[i] = question;
        }

        Engine.play(scanner, TASK, questions, correctAnswers);
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

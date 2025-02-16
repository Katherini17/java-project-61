package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class ProgressionGame {

    public static void play(Scanner scanner) {
        Engine.sendWelcomeMessage();
        var userName = Engine.askUserName(scanner);
        Engine.sendGreetingByNameMessage(userName);
        // Задаем максимальное и минимальное число элементов прогрессии
        final int MIN_LENGTH = 5;
        final int MAX_LENGTH = 10;
        // Каждый элемент арифметической прогрессии задается формулой:
        // an = a1 + (n - 1)*d,
        // где a1 - первый элемент арифметической прогрессии,
        //     d - разность арифметической прогрессии.
        // Пусть d будет случайным числом от 3 до 25
        final int MIN_COMMON_DIFFERENCE = 3;
        final int MAX_COMMON_DIFFERENCE = 25;
        // Пусть первый элемент прогрессии будет случайным числом от 5 до 70
        final int MIN_FIRST_ELEMENT = 5;
        final int MAX_FIRST_ELEMENT = 70;
        // Сообщаем пользователю задание для игры
        var task = "What number is missing in the progression?";
        Engine.printTask(task);

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            // Получаем длину арифметической прогрессии
            var length = Engine.generateElementInRange(MIN_LENGTH, MAX_LENGTH);
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
            // Скрываем элемент
            elements[positionOfHiddenElement] = "..";
            String question = String.join(" ", elements);
            Engine.askUser(question);
            var userHiddenElement = Engine.getUserAnswer(scanner);
            var isCorrectAnswer = Engine.checkAnswer(userHiddenElement, correctHiddenElement);
            Engine.printResult(userHiddenElement, correctHiddenElement, isCorrectAnswer, userName);
            var isFinalRound = i == Engine.ROUNDS_COUNT - 1;
            if (!isCorrectAnswer) {
                return;
            }
            if (isFinalRound) {
                Engine.congratulate(userName);
            }
        }
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

package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class ProgressionGame {

    public static void play(Scanner scanner) {
        Engine.sendWelcomeMessage();
        var userName = Engine.askUserName(scanner);
        Engine.sendGreetingByNameMessage(userName);
        // Задаем количество раундов
        var roundsCount = Engine.defaultRoundsCount;
        // Задаем максимальное и минимальное число элементов прогрессии
        var minLength = 5;
        var maxLength = 10;
        // Каждый элемент арифметической прогрессии задается формулой:
        // an = a1 + (n - 1)*d,
        // где a1 - первый элемент арифметической прогрессии,
        //     d - разность арифметической прогрессии.
        // Пусть d будет случайным числом от 3 до 25
        var minCommonDifference = 3;
        var maxCommonDifference = 25;
        // Пусть первый элемент прогрессии будет случайным числом от 5 до 70
        var minFirstElement = 5;
        var maxFirstElement = 70;
        // Сообщаем пользователю задание для игры
        var task = "What number is missing in the progression?";
        Engine.printTask(task);

        for (int i = 0; i < roundsCount; i++) {
            // Получаем длину арифметической прогрессии
            var length = Engine.generateElementInRange(minLength, maxLength);
            // Получаем разность арифметической прогрессии
            var commonDifference = Engine.generateElementInRange(minCommonDifference, maxCommonDifference);
            // Получаем первый элемент арифметической прогрессии
            var firstElement = Engine.generateElementInRange(minFirstElement, maxFirstElement);
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
            var isFinalRound = i == roundsCount - 1;
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

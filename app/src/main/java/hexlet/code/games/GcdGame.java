package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class GcdGame {
    public static void play(Scanner scanner) {
        // Приветствуем пользователя
        Engine.sendWelcomeMessage();
        var userName = Engine.askUserName(scanner);
        Engine.sendGreetingByNameMessage(userName);
        // Задаем количество раундов
        // Задаем максимальное случайное число
        // Сообщаем пользователю задание для игры
        var task = "Find the greatest common divisor of given numbers.";
        Engine.printTask(task);

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            // Получаем два случайных числа
            var number1 = getNewNumber();
            var number2 = getNewNumber();
            // Вычисляем наименьший общий делитель
            var correctAnswer = Integer.toString(calcGCD(number1, number2));
            // Узнаем ответ пользователя
            var question = number1 + " " + number2;
            Engine.askUser(question);
            var userAnswer = Engine.getUserAnswer(scanner);
            // Проверяем ответ пользователя
            var isCorrectAnswer = Engine.checkAnswer(userAnswer, correctAnswer);
            // Выводим результат
            Engine.printResult(userAnswer, correctAnswer, isCorrectAnswer, userName);
            if (!isCorrectAnswer) {
                return;
            }
            // Узнаем, был ли текущий раунд финальным
            var isFinalRound = i == Engine.ROUNDS_COUNT - 1;
            // Если раунд был финальным, поздравляем пользователя
            if (isFinalRound) {
                Engine.congratulate(userName);
            }
        }
    }

    public static int calcGCD(int number1, int number2) {
        // По алгоритму Евклида вычисляем наибольший общий делитель.
        // Делим большее число на меньшее, получаем остаток от деления.
        // Если остаток от деления равен нулю - меньшее число и есть НОД.
        // Если остаток от деления не равен нулю, заменяем:
        // большее число на меньшее;
        // меньшее число на остаток от деления.
        // Повторяем шаги до тех пор, пока остаток от деления не будет равен нулю.
        // В данном случае сразу заменяем большее число на меньшее,
        // меньшее на остаток от деления, повторяем шаги до тех пор,
        // пока меньшее число (т. е. остаток от деления на предыдущем шаге) не будет равен нулю
        // Как только меньшее число будет равен нулю,
        // Возвращаем большее (т. е. меньшее число на предыдущем шаге) число.
        var maxNumber = Math.max(number1, number2);
        var minNumber = Math.min(number1, number2);

        while (minNumber != 0) {
            var remainder = maxNumber % minNumber;
            maxNumber = minNumber;
            minNumber = remainder;
        }

        return maxNumber;
    }

    public static int getNewNumber() {
        final int LIMIT = 30;
        return Engine.generateRandomNumber(LIMIT);
    }
}

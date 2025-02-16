package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class EvenGame {

    public static void play(Scanner scanner) {
        // Приветствуем пользователя
        Engine.sendWelcomeMessage();
        var userName = Engine.askUserName(scanner);
        Engine.sendGreetingByNameMessage(userName);
        // Задаем количество раундов
        var roundsCount = Engine.defaultRoundsCount;
        // Задаем максимальное случайное число
        var limit = 1000;
        // Сообщаем пользователю задание для игры
        var task = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Engine.printTask(task);
        for (int i = 0; i < roundsCount; i++) {
            // Получаем случайное число
            var newNumber = Engine.generateRandomNumber(limit);
            // Узнаем правильный ответ
            var correctAnswer = isEven(newNumber) ? "yes" : "no";
            // Задаем вопрос пользователю
            var question = Integer.toString(newNumber);
            Engine.askUser(question);
            // Получаем ответ пользователя
            var userAnswer = Engine.getUserAnswer(scanner);
            // Проверяем ответ пользователя
            var isCorrectAnswer = Engine.checkAnswer(userAnswer, correctAnswer);
            // Выводим результат в зависимости от того, как ответил пользователь
            Engine.printResult(userAnswer, correctAnswer, isCorrectAnswer, userName);
            // Проверяем, является ли текущий раунд финальным
            // Если раунд финальный - поздравляем пользователя
            var isFinalRound = i == roundsCount - 1;
            if (!isCorrectAnswer) {
                return;
            }
            if (isFinalRound) {
                Engine.congratulate(userName);
            }
        }

    }

    public static boolean isEven(int number) {
        // Проверяем, является ли число четным
        // Число является четным если делиться на 2 без остатка
        return number % 2 == 0;

    }

}

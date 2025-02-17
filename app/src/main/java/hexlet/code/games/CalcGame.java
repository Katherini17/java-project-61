package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class CalcGame {

    public static final Integer MAX_RANDOM_NUMBER = 30;

    public static void play(Scanner scanner) {
        // Приветствуем пользователя
        Engine.sendWelcomeMessage();
        var userName = Engine.askUserName(scanner);
        Engine.sendGreetingByNameMessage(userName);
        // Задаем количество раундов
        int roundsCount = Engine.DEFAULT_ROUNDS_COUNT;
        // Задаем максимальное случайное число
        // Объясняем пользователю условие игры
        var task = "What is the result of the expression?";
        Engine.printTask(task);

        for (int i = 0; i < roundsCount; i++) {
            var number1 = Engine.generateRandomNumber(MAX_RANDOM_NUMBER);
            var number2 = Engine.generateRandomNumber(MAX_RANDOM_NUMBER);
            var operator = generateOperator();
            var correctAnswer = Integer.toString(calcExpression(number1, number2, operator));

            var question = number1 + " " + operator + " " + number2;
            Engine.askUser(question);
            var userAnswer = Engine.getUserAnswer(scanner);
            var isCorrectAnswer = Engine.checkAnswer(userAnswer, correctAnswer);

            Engine.printResult(userAnswer, correctAnswer, isCorrectAnswer, userName);

            var isFinalRound = i == roundsCount - 1;
            if (!isCorrectAnswer) {
                return;
            }
            if (isFinalRound) {
                Engine.congratulate(userName);
            }
        }
    }

    public static char generateOperator() {
        // Количество арифметических операций: "+", "-", "*"
        var limit = 3;
        var generatedNumber = Engine.generateRandomNumber(limit);
        switch (generatedNumber) {
            case 1:
                return '+';
            case 2:
                return '-';
            default:
                return '*';
        }
    }

    public static int calcExpression(int number1, int number2, char operator) {
        switch (operator) {
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            default:
                return number1 * number2;
        }
    }

}

package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class CalcGame {

    public static final Integer MAX_RANDOM_NUMBER = 30;

    public static final Integer OPERATORS_COUNT = 3;
    private static final char ADDITION_SYMBOL = '+';
    private static final char SUBTRACTION_SYMBOL = '-';
    private static final char MULTIPLICATION_SYMBOL = '*';
    public static final String TASK = "What is the result of the expression?";

    public static void play(Scanner scanner) {

        var questions = new String[Engine.DEFAULT_ROUNDS_COUNT];
        var correctAnswers = new String[Engine.DEFAULT_ROUNDS_COUNT];

        for (int i = 0; i < Engine.DEFAULT_ROUNDS_COUNT; i++) {
            var number1 = Engine.generateRandomNumber(MAX_RANDOM_NUMBER);
            var number2 = Engine.generateRandomNumber(MAX_RANDOM_NUMBER);

            var operator = generateOperator();

            var correctAnswer = Integer.toString(calcExpression(number1, number2, operator));
            correctAnswers[i] = correctAnswer;

            var question = number1 + " " + operator + " " + number2;
            questions[i] = question;
        }

        Engine.runGame(scanner, TASK, questions, correctAnswers);
    }

    public static char generateOperator() {
        var generatedNumber = Engine.generateRandomNumber(OPERATORS_COUNT);
        switch (generatedNumber) {
            case 1:
                return ADDITION_SYMBOL;
            case 2:
                return SUBTRACTION_SYMBOL;
            default:
                return MULTIPLICATION_SYMBOL;
        }
    }

    public static int calcExpression(int number1, int number2, char operator) {
        switch (operator) {
            case ADDITION_SYMBOL:
                return number1 + number2;
            case SUBTRACTION_SYMBOL:
                return number1 - number2;
            default:
                return number1 * number2;
        }
    }

}

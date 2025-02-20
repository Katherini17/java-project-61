package hexlet.code.games;

import hexlet.code.Engine;

public class CalcGame {

    public static final Integer MAX_RANDOM_NUMBER = 30;

    public static final Integer OPERATORS_COUNT = 3;
    private static final char ADDITION_SYMBOL = '+';
    private static final char SUBTRACTION_SYMBOL = '-';
    private static final char MULTIPLICATION_SYMBOL = '*';
    public static final String TASK = "What is the result of the expression?";

    public static void play() {

        String[][] data = new String[2][Engine.DEFAULT_ROUNDS_COUNT];

        for (int i = 0; i < Engine.DEFAULT_ROUNDS_COUNT; i++) {
            int number1 = Engine.generateRandomNumber(MAX_RANDOM_NUMBER);
            int number2 = Engine.generateRandomNumber(MAX_RANDOM_NUMBER);

            char operator = generateOperator();

            String question = number1 + " " + operator + " " + number2;
            data[0][i] = question;

            String correctAnswer = Integer.toString(calcExpression(number1, number2, operator));
            data[1][i] = correctAnswer;

        }

        Engine.runGame(TASK, data);
    }

    public static char generateOperator() {
        int generatedNumber = Engine.generateRandomNumber(OPERATORS_COUNT);
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

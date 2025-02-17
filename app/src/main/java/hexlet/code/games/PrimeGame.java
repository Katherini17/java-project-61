package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class PrimeGame {
    public static final Integer MAX_RANDOM_NUMBER = 53;

    public static void play(Scanner scanner) {
        Engine.sendWelcomeMessage();
        var userName = Engine.askUserName(scanner);
        Engine.sendGreetingByNameMessage(userName);
        int roundsCount = Engine.DEFAULT_ROUNDS_COUNT;
        var task = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Engine.printTask(task);
        for (int i = 0; i < roundsCount; i++) {
            var newNumber = Engine.generateRandomNumber(MAX_RANDOM_NUMBER);
            var correctAnswer = isPrimeNumber(newNumber) ? "yes" : "no";
            var question = Integer.toString(newNumber);
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

    public static boolean isPrimeNumber(int number) {

        if (number == 1) {
            return false;
        }

        var rootOfNumber = (int) Math.sqrt(number);

        for (int i = 2; i <= rootOfNumber; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}

package hexlet.code;

import java.util.Scanner;

public class EvenGame {

    public static void playEvenGame() {

        var Scanner = new Scanner(System.in);
        var randomGenerator = new RandomGenerator(117);
        var roundsCount = 3;
        var isGameOver = false;
        var currentRoundsCount = 0;

        var isSuccessfulRound = true;
        while(isSuccessfulRound) {

            var newNumber = randomGenerator.generateNextNumber();
            var isNumberEven = isEven();
            var correctAnswer = isNumberEven() ? "yes" : "no";

            var userAnswer = scanner.nextLine();
            var isCorrectAnswer = userAnswer == correctAnswer;

            if (isCorrectAnswer && !isGameOver) {

                tellCorrect();
                currentRoundsCount++;
                isGameOver = currentRoundsCount == roundsCount;

                if (isGameOver) {
                    congratulate()
                }

            } else {

                tellIncorrect(String userAnswer, String correctAnswer);
                isCorrectAnswer = false;

            }

        }




    }

}

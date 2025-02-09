package hexlet.code.evenGame;

import java.util.Scanner;
// import hexlet.code.evenGame.RandomGenerator;

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
            var isNumberEven = isEven(newNumber);
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
                randomGenerator.reset();

            }

        }

    }

    public boolean isEven(int number) {
        // Проверяем, является ли число четным
        // Число является четным если делиться на 2 без остатка
        return number % 2 == 0;
    }



}

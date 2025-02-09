package hexlet.code.evenGame;

import java.util.Scanner;
// import hexlet.code.evenGame.RandomGenerator;

public class EvenGame {

    public static void playEvenGame() {

        var scanner = new Scanner(System.in);
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
            var isCorrectAnswer = userAnswer.equals(correctAnswer);

            if (isCorrectAnswer && !isGameOver) {

                tellCorrect();
                currentRoundsCount++;
                isGameOver = currentRoundsCount == roundsCount;

                if (isGameOver) {
                    congratulate()
                }

            } else {

                tellIncorrect(userAnswer, correctAnswer);
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

    public void tellCorrect() {
        System.out.println("Correct!");
    }

    public void tellIncorrect(String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " +  +"!");
    }

}

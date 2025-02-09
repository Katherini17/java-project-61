package hexlet.code.evenGame;

import hexlet.code.Greeting;
import hexlet.code.User;

import java.util.Scanner;
// import hexlet.code.evenGame.RandomGenerator;

public class EvenGame {

    public static void playEvenGame() {

        var user = new User();
        Greeting.greet(user);

        var name = user.getName();

        var scanner = new Scanner(System.in);
        var randomGenerator = new RandomGenerator(117);

        var roundsCount = 3;
        var isGameOver = false;
        var currentRoundsCount = 0;

        var isSuccessfulRound = true;
        while (isSuccessfulRound && !isGameOver) {

            var newNumber = randomGenerator.generateNextNumber();
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
            var correctAnswer = isEven(newNumber) ? "yes" : "no";
            System.out.println("Question: " + newNumber);

            var userAnswer = scanner.nextLine();
            var isCorrectAnswer = userAnswer.equals(correctAnswer);



            if (isCorrectAnswer) {

                tellCorrect();
                currentRoundsCount++;
                isGameOver = currentRoundsCount == roundsCount;

                if (isGameOver) {
                    congratulate(name);
                }

            } else {

                tellIncorrect(name, userAnswer, correctAnswer);
                isSuccessfulRound = false;

            }

        }

    }

    public static boolean isEven(int number) {
        // Проверяем, является ли число четным
        // Число является четным если делиться на 2 без остатка
        return number % 2 == 0;
    }

    public static void tellCorrect() {
        System.out.println("Correct!");
    }

    public static void tellIncorrect(String userName, String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + userName + "!");
    }

    public static void congratulate(String userName) {
        System.out.println("Congratulations, " + userName + "!");
    }

}

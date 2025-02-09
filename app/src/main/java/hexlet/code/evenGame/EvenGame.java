package hexlet.code.evenGame;

import hexlet.code.Greeting;
import hexlet.code.User;

import java.util.Scanner;

import static hexlet.code.evenGame.RandomGenerator.generateRandomNumber;
// import hexlet.code.evenGame.RandomGenerator;

public class EvenGame {

    public static void playEvenGame() {

        var user = new User();
        Greeting.greet(user);
        var name = user.getName();

        var scanner = new Scanner(System.in);

        // Количество раундов в в одной игре
        var roundsCount = 3;

        // Закончена ли игра. Игра считается законченной, если успешно прошло roundsCount раундов
        var isGameOver = false;

        // Счетчик раундов
        var currentRoundsCount = 0;

        // Максимальное случайное число
        var limit = 275;


        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (!isGameOver) {

            // Получаем случайное число
            var newNumber = generateRandomNumber(limit);
            // Узнаем правильный ответ
            var correctAnswer = isEven(newNumber) ? "yes" : "no";
            System.out.println("Question: " + newNumber);
            // Получаем ответ пользователя
            var userAnswer = scanner.nextLine();
            // Проверяем, совпадает ли ответ пользователя с правильным ответов
            var isCorrectAnswer = userAnswer.equals(correctAnswer);

            if (isCorrectAnswer) {
                // Если пользователь ответил верно,
                // то сообщаем пользователю об этом
                tellCorrect();
                // Увеличиваем счетчик пройденных раундов
                currentRoundsCount++;
                // Проверяем, является ли текущий раунд финальным
                isGameOver = currentRoundsCount == roundsCount;
                // Если пройденный раунд был финальным,
                // поздравляем пользователя с успешно пройденной игрой!
                if (isGameOver) {
                    congratulate(name);
                }

            } else {

                tellIncorrect(name, userAnswer, correctAnswer);
                isGameOver = true;

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

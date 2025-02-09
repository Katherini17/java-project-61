package hexlet.code.evenGame;

public class RandomGenerator {

    // Используется линейный конгруэнтный метод для вычисления псевдослучайного числа
    // Каждое новое число вычисляется по формуле
    // Xn+1 = (a * Xn + c) % m,
    // где X0 (seed) - начальное значение.

    private int seed;
    private int currentNumber;

    RandomGenerator(int seed) {
        this.seed = seed;
        this.currentNumber = seed;
    }

    public int generateNextNumber() {

        var a = 7;
        var c = 35;
        var m = 285;

        var randomNumber = (a * currentNumber + c) % m;
        currentNumber = randomNumber;
        return randomNumber;
    }

    public void reset() {
        currentNumber = seed;
    }
}

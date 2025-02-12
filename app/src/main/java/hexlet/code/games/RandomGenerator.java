package hexlet.code.games;

public class RandomGenerator {

    public static int generateRandomNumber(int limit) {
        int randomNumber = (int) (Math.random() * limit) + 1;
        return randomNumber;
    }

}

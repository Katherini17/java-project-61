package hexlet.code;

import java.util.Random;

public class RandomUtil {

    public static int generateElementInRange(int min, int max) {
        Random random = new Random();

        int range = max - min + 1;
        return random.nextInt(range) + min;
    }

}

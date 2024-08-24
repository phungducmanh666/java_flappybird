package utils;

import java.util.Random;

public class NumberUtil {

    public static Random random = new Random();

    public static int randomIntInRange(int min, int max){
        return random.nextInt(max + 1 - min) + min;
    }
}

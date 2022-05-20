package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    static Random random = new Random();

    // 서로 다른 숫자 3개 List로 반환
    public static List<Integer> getRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int num = getRandomNumber();
            if (!numbers.contains(num))
                numbers.add(num);
        }
        return numbers;
    }

    // 랜덤 숫자 1 ~ 9 반환
    public static int getRandomNumber() {
        return random.nextInt(9) + 1;
    }
}

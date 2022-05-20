import java.util.ArrayList;
import java.util.List;

public class RandomUtil {

    static List<Integer> getRandomNumberList(int size) {
        List<Integer> nums = new ArrayList<>();

        while (nums.size() < size) {
            int randNumber = getRandomNumber();
            addNumberIfNumberIsNotDuplicate(nums, randNumber);
        }

        return nums;
    }

    private static int getRandomNumber() {
        int randNum = 10;
        while (randNum == 10) randNum = (int)(Math.random() * 10) + 1;
        return randNum;
    }

    private static void addNumberIfNumberIsNotDuplicate(List<Integer> nums, int randNumber) {
        if (!nums.contains(randNumber)) {
            nums.add(randNumber);
        }
    }

}

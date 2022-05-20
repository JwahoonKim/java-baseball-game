import java.util.List;

public class Checker {

    static final int NUMS_LENGHT = 3;

    static int strikeCount(List<Integer> nums, List<Integer> answer) {
        int strike = 0;

        for (int i = 0; i < NUMS_LENGHT; i ++) {
            if (nums.get(i).equals(answer.get(i)))
                strike += 1;
        }

        return strike;
    }

    static int ballCount(List<Integer> nums, List<Integer> answer) {
        int ball = 0;

        for (int i = 0; i < NUMS_LENGHT; i ++) {
            Integer num = nums.get(i);
            if (answer.contains(num) && !answer.get(i).equals(num))
                ball += 1;
        }

        return ball;
    }

}

package domain;

public class Result {
    public static final int THREE_STRIKE = 3;
    final int strike;
    final int ball;
    boolean isEnd = false;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;

        if (strike == THREE_STRIKE)
            isEnd = true;
    }

    public boolean isOut() {
        return strike == 0 && ball == 0;
    }
}

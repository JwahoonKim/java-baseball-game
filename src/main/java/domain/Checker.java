package domain;

import java.util.List;

public class Checker {

    public static final int BALL_LENGTH = 3;

    // 컴퓨터 정답과 플레이어 입력 받아서 결과 알려주는 함수
    public static Result play(Balls computer, Balls player) {
        return new Result(strikeCount(computer, player), ballCount(computer, player));
    }

    private static int strikeCount(Balls computer, Balls player) {
        int strike = 0;
        for (int i = 0; i < BALL_LENGTH; i ++) {
            if(computer.getStatus(i, player).isStrike())
                strike++;
        }
        return strike;
    }

    private static int ballCount(Balls computer, Balls player) {
        int ball = 0;
        for (int i = 0; i < BALL_LENGTH; i ++) {
            if(computer.getStatus(i, player).isBall())
                ball++;
        }
        return ball;
    }
}

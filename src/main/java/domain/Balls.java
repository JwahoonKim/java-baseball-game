package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Balls {
    final List<Ball> balls;

    public Balls(List<Integer> ballList) {
        if (ballList.size() != 3)
            throw new IllegalArgumentException("숫자의 크기는 세 자리여야합니다.");

        balls = mapBall(ballList);
    }

    private List<Ball> mapBall(List<Integer> ballList) {
        return ballList.stream()
                .map(Ball::new)
                .collect(Collectors.toList());
    }

    // 비교 로직
    public BallStatus getStatus(int index, Balls another) {
        if (getBall(index).equals(another.getBall(index)))
            return BallStatus.STRIKE;
        if (another.balls.contains(getBall(index)))
            return BallStatus.BALL;
        return BallStatus.NOTHING;
    }

    private Ball getBall(int index) {
        return balls.get(index);
    }

}

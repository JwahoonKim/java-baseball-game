package domain;

import java.util.Objects;

public class Ball {
    final int number;

    public Ball(int number) {
        if (number <= 0 || number > 9)
            throw new IllegalArgumentException("숫자는 1 ~ 9 사이만 가능합니다.");
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

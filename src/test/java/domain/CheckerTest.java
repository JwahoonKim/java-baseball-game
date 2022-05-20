package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

    Balls computer;

    @BeforeEach
    void setUp() {
        computer = new Balls(Arrays.asList(1,2,3));
    }

    @Test
    void play_아웃() {
        Balls player = new Balls(Arrays.asList(4,5,6));
        Result result = Checker.play(computer, player);
        assertThat(result.isOut()).isTrue();
    }

    @Test
    void play_1스트라이크_2볼() {
        Balls player = new Balls(Arrays.asList(1,3,2));
        Result result = Checker.play(computer, player);
        assertThat(result.strike).isEqualTo(1);
        assertThat(result.ball).isEqualTo(2);
    }

    @Test
    void play_3스트라이크() {
        Balls player = new Balls(Arrays.asList(1,2,3));
        Result result = Checker.play(computer, player);
        assertThat(result.isEnd).isTrue();
    }
}
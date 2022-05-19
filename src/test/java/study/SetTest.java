package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Set Collection API Test")
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set size() Test")
    @Test
    void size() {
        final int expectedSize = 3;
        assertThat(numbers.size()).isEqualTo(expectedSize);
    }

    @Test
    void contains1() {
        // 중복 코드가 생김! -> 개선 필요 by ParameterizedTest & ValueSource
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains1_개선(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1,true","2,true","3,true","4,false", "5,false"})
    void contains2(int num, boolean expected) {
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }
}

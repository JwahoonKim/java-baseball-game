package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void spilt1() {
        String actual = "1,2";
        String[] split = actual.split(",");
        assertThat(split).contains("1", "2");
    }

    @Test
    void split2() {
        String actual = "1";
        String[] split = actual.split(",");
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)";
        String substring = actual.substring(1, actual.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt method test")
    void charAt() {
        String actual = "abc";
        char c1 = actual.charAt(0);
        char c2 = actual.charAt(1);

        assertThat(c1).isEqualTo('a');
        assertThat(c2).isEqualTo('b');
        assertThatThrownBy(() -> actual.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}

package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class Task1Test {
    @Test
    public void validInputShouldReturnCorrectTotalSeconds() {
        assertThat(Task1.minutesToSeconds("01:00")).isEqualTo(60);
        assertThat(Task1.minutesToSeconds("13:56")).isEqualTo(836);
        assertThat(Task1.minutesToSeconds("999:59")).isEqualTo(59999);
    }

    @Test
    public void invalidSecondsShouldReturnNegativeResult() {
        assertThat(Task1.minutesToSeconds("10:60")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("02:500")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("12:-44")).isEqualTo(-1);
    }

    @Test
    public void invalidMinutesShouldReturnNegativeResult() {
        assertThat(Task1.minutesToSeconds("-01:00")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("-12:44")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("-999:59")).isEqualTo(-1);
    }

    @Test
    public void invalidFormatShouldReturnNegativeResult() {
        assertThat(Task1.minutesToSeconds("10:20:30")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("abc:def")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("1234")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("1:2")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("1:34")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("01:2")).isEqualTo(-1);
    }
}

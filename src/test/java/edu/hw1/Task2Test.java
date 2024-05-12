package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    public void positiveNumberShouldReturnCorrectCountOfDigitsInNumber() {
        assertThat(Task2.countDigits(4666)).isEqualTo(4);
        assertThat(Task2.countDigits(544)).isEqualTo(3);
        assertThat(Task2.countDigits(7)).isEqualTo(1);
    }

    @Test
    public void ZeroNumberShouldReturnOne() {
        assertThat(Task2.countDigits(0)).isEqualTo(1);
    }

    @Test
    public void NegativeNumberShouldReturnCorrectCountOfDigitsInNumber() {
        assertThat(Task2.countDigits(-4666)).isEqualTo(4);
        assertThat(Task2.countDigits(-544)).isEqualTo(3);
        assertThat(Task2.countDigits(-9)).isEqualTo(1);
    }
}

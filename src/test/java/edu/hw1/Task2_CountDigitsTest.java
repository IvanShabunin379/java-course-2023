package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class Task2_CountDigitsTest {
    @Test
    public void positiveNumberShouldReturnCorrectCountOfDigitsInNumber() {
        assertThat(Task2_CountDigits.countDigits(4666)).isEqualTo(4);
        assertThat(Task2_CountDigits.countDigits(544)).isEqualTo(3);
        assertThat(Task2_CountDigits.countDigits(7)).isEqualTo(1);
    }

    @Test
    public void ZeroNumberShouldReturnOne() {
        assertThat(Task2_CountDigits.countDigits(0)).isEqualTo(1);
    }

    @Test
    public void NegativeNumberShouldReturnCorrectCountOfDigitsInNumber() {
        assertThat(Task2_CountDigits.countDigits(-4666)).isEqualTo(4);
        assertThat(Task2_CountDigits.countDigits(-544)).isEqualTo(3);
        assertThat(Task2_CountDigits.countDigits(-9)).isEqualTo(1);
    }
}

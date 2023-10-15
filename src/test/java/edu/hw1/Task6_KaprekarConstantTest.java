package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class Task6_KaprekarConstantTest {
    @Test
    public void fourDigitNumberGreaterThanThousandWithoutAllEqualDigitsShouldReturnCountOfStepsToGetKaprekarConstant() {
        assertThat(Task6_KaprekarConstant.countK(6621)).isEqualTo(5);
        assertThat(Task6_KaprekarConstant.countK(6554)).isEqualTo(4);
        assertThat(Task6_KaprekarConstant.countK(1234)).isEqualTo(3);
        assertThat(Task6_KaprekarConstant.countK(3524)).isEqualTo(3);
    }

    @Test
    public void kaprekarConstantShouldReturnZero() {
        assertThat(Task6_KaprekarConstant.countK(Task6_KaprekarConstant.getKaprekarConst())).isEqualTo(0);
    }

    @Test
    public void FourDigitNumberWithAllEqualDigitsShouldReturnNegativeResult() {
        assertThat(Task6_KaprekarConstant.countK(1111)).isEqualTo(-1);
        assertThat(Task6_KaprekarConstant.countK(7777)).isEqualTo(-1);
        assertThat(Task6_KaprekarConstant.countK(9999)).isEqualTo(-1);
    }

    @Test
    public void ThousandShouldReturnNegativeResult() {
        assertThat(Task6_KaprekarConstant.countK(1000)).isEqualTo(-1);
    }

    @Test
    public void NegativeNumberShouldReturnNegativeResult() {
        assertThat(Task6_KaprekarConstant.countK(-1234)).isEqualTo(-1);
        assertThat(Task6_KaprekarConstant.countK(-6621)).isEqualTo(-1);
        assertThat(Task6_KaprekarConstant.countK(-9999)).isEqualTo(-1);
        assertThat(Task6_KaprekarConstant.countK(-10)).isEqualTo(-1);
    }

    @Test
    public void NonFourDigitNumberShouldReturnNegativeResult() {
        assertThat(Task6_KaprekarConstant.countK(0)).isEqualTo(-1);
        assertThat(Task6_KaprekarConstant.countK(9)).isEqualTo(-1);
        assertThat(Task6_KaprekarConstant.countK(123)).isEqualTo(-1);
        assertThat(Task6_KaprekarConstant.countK(10000)).isEqualTo(-1);
    }
}

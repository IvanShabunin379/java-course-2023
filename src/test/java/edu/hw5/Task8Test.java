package edu.hw5;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class Task8Test {
    @Test
    public void testHasOddLength() {
        assertThat(Task8.hasOddLength("0")).isTrue();
        assertThat(Task8.hasOddLength("011")).isTrue();
        assertThat(Task8.hasOddLength("1101101")).isTrue();

        assertThat(Task8.hasOddLength("")).isFalse();
        assertThat(Task8.hasOddLength("10")).isFalse();
        assertThat(Task8.hasOddLength("110100")).isFalse();
    }

    @Test
    public void testStartsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength() {
        assertThat(Task8.startsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength("0")).isTrue();
        assertThat(Task8.startsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength("01001")).isTrue();
        assertThat(Task8.startsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength("10")).isTrue();
        assertThat(Task8.startsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength("11111111")).isTrue();

        assertThat(Task8.startsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength("01")).isFalse();
        assertThat(Task8.startsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength("1")).isFalse();
        assertThat(Task8.startsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength("0110")).isFalse();
        assertThat(Task8.startsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength("10010")).isFalse();
    }

    @Test
    public void testCountOfZerosIsMultipleOfThree() {
        assertThat(Task8.countOfZerosIsMultipleOfThree("000")).isTrue();
        assertThat(Task8.countOfZerosIsMultipleOfThree("101001")).isTrue();
        assertThat(Task8.countOfZerosIsMultipleOfThree("0111101101110011110")).isTrue();

        assertThat(Task8.countOfZerosIsMultipleOfThree("00")).isFalse();
        assertThat(Task8.countOfZerosIsMultipleOfThree("1010010")).isFalse();
        assertThat(Task8.countOfZerosIsMultipleOfThree("011110111110110110")).isFalse();
    }

    @Test
    public void testIsNot11AndNot111() {
        assertThat(Task8.isNot11AndNot111("11")).isFalse();
        assertThat(Task8.isNot11AndNot111("111")).isFalse();

        assertThat(Task8.isNot11AndNot111("")).isTrue();
        assertThat(Task8.isNot11AndNot111("110")).isTrue();
        assertThat(Task8.isNot11AndNot111("01010111")).isTrue();
        assertThat(Task8.isNot11AndNot111("000")).isTrue();
    }

    @Test
    public void testEachOddCharIsOne() {
        assertThat(Task8.eachOddCharIsOne("1")).isTrue();
        assertThat(Task8.eachOddCharIsOne("111")).isTrue();
        assertThat(Task8.eachOddCharIsOne("1010111")).isTrue();

        assertThat(Task8.eachOddCharIsOne("0")).isFalse();
        assertThat(Task8.eachOddCharIsOne("110")).isFalse();
        assertThat(Task8.eachOddCharIsOne("0010111")).isFalse();
    }
}

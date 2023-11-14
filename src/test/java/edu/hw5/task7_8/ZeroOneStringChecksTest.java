package edu.hw5.task7_8;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ZeroOneStringChecksTest {
    //------- Задание 7 --------

    @Test
    public void testContainsAtLeastThreeCharsAndThirdCharIsZero() {
        assertThat(ZeroOneStringCheckers.containsAtLeastThreeCharsAndThirdCharIsZero("000")).isTrue();
        assertThat(ZeroOneStringCheckers.containsAtLeastThreeCharsAndThirdCharIsZero("11011")).isTrue();
        assertThat(ZeroOneStringCheckers.containsAtLeastThreeCharsAndThirdCharIsZero("010101")).isTrue();

        assertThat(ZeroOneStringCheckers.containsAtLeastThreeCharsAndThirdCharIsZero("")).isFalse();
        assertThat(ZeroOneStringCheckers.containsAtLeastThreeCharsAndThirdCharIsZero("00")).isFalse();
        assertThat(ZeroOneStringCheckers.containsAtLeastThreeCharsAndThirdCharIsZero("1")).isFalse();
    }

    @Test
    public void testStartsAndEndsWithSameChar() {
        assertThat(ZeroOneStringCheckers.startsAndEndsWithSameChar("1")).isTrue();
        assertThat(ZeroOneStringCheckers.startsAndEndsWithSameChar("101")).isTrue();
        assertThat(ZeroOneStringCheckers.startsAndEndsWithSameChar("00000")).isTrue();
        assertThat(ZeroOneStringCheckers.startsAndEndsWithSameChar("01000110100")).isTrue();

        assertThat(ZeroOneStringCheckers.startsAndEndsWithSameChar("01")).isFalse();
        assertThat(ZeroOneStringCheckers.startsAndEndsWithSameChar("1000")).isFalse();
        assertThat(ZeroOneStringCheckers.startsAndEndsWithSameChar("000111001")).isFalse();
    }

    @Test
    public void testIsNoShorterThanOneAndNotLongerThanThree() {
        assertThat(ZeroOneStringCheckers.isNoShorterThanOneAndNotLongerThanThree("0")).isTrue();
        assertThat(ZeroOneStringCheckers.isNoShorterThanOneAndNotLongerThanThree("01")).isTrue();
        assertThat(ZeroOneStringCheckers.isNoShorterThanOneAndNotLongerThanThree("111")).isTrue();

        assertThat(ZeroOneStringCheckers.isNoShorterThanOneAndNotLongerThanThree("")).isFalse();
        assertThat(ZeroOneStringCheckers.isNoShorterThanOneAndNotLongerThanThree("1001")).isFalse();
        assertThat(ZeroOneStringCheckers.isNoShorterThanOneAndNotLongerThanThree("00010100110")).isFalse();
    }

    //------- Задание 7 --------

    @Test
    public void testHasOddLength() {
        assertThat(ZeroOneStringCheckers.hasOddLength("0")).isTrue();
        assertThat(ZeroOneStringCheckers.hasOddLength("011")).isTrue();
        assertThat(ZeroOneStringCheckers.hasOddLength("1101101")).isTrue();

        assertThat(ZeroOneStringCheckers.hasOddLength("")).isFalse();
        assertThat(ZeroOneStringCheckers.hasOddLength("10")).isFalse();
        assertThat(ZeroOneStringCheckers.hasOddLength("110100")).isFalse();
    }

    @Test
    public void testStartsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength() {
        assertThat(ZeroOneStringCheckers.startsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength("0")).isTrue();
        assertThat(ZeroOneStringCheckers.startsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength("01001")).isTrue();
        assertThat(ZeroOneStringCheckers.startsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength("10")).isTrue();
        assertThat(ZeroOneStringCheckers.startsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength("11111111")).isTrue();

        assertThat(ZeroOneStringCheckers.startsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength("01")).isFalse();
        assertThat(ZeroOneStringCheckers.startsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength("1")).isFalse();
        assertThat(ZeroOneStringCheckers.startsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength("0110")).isFalse();
        assertThat(ZeroOneStringCheckers.startsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength("10010")).isFalse();
    }

    @Test
    public void testCountOfZerosIsMultipleOfThree() {
        assertThat(ZeroOneStringCheckers.countOfZerosIsMultipleOfThree("000")).isTrue();
        assertThat(ZeroOneStringCheckers.countOfZerosIsMultipleOfThree("101001")).isTrue();
        assertThat(ZeroOneStringCheckers.countOfZerosIsMultipleOfThree("0111101101110011110")).isTrue();

        assertThat(ZeroOneStringCheckers.countOfZerosIsMultipleOfThree("00")).isFalse();
        assertThat(ZeroOneStringCheckers.countOfZerosIsMultipleOfThree("1010010")).isFalse();
        assertThat(ZeroOneStringCheckers.countOfZerosIsMultipleOfThree("011110111110110110")).isFalse();
    }

    @Test
    public void testIsNot11AndNot111() {
        assertThat(ZeroOneStringCheckers.isNot11AndNot111("11")).isFalse();
        assertThat(ZeroOneStringCheckers.isNot11AndNot111("111")).isFalse();

        assertThat(ZeroOneStringCheckers.isNot11AndNot111("")).isTrue();
        assertThat(ZeroOneStringCheckers.isNot11AndNot111("110")).isTrue();
        assertThat(ZeroOneStringCheckers.isNot11AndNot111("01010111")).isTrue();
        assertThat(ZeroOneStringCheckers.isNot11AndNot111("000")).isTrue();
    }

    @Test
    public void testEachOddCharIsOne() {
        assertThat(ZeroOneStringCheckers.eachOddCharIsOne("1")).isTrue();
        assertThat(ZeroOneStringCheckers.eachOddCharIsOne("111")).isTrue();
        assertThat(ZeroOneStringCheckers.eachOddCharIsOne("1010111")).isTrue();

        assertThat(ZeroOneStringCheckers.eachOddCharIsOne("0")).isFalse();
        assertThat(ZeroOneStringCheckers.eachOddCharIsOne("110")).isFalse();
        assertThat(ZeroOneStringCheckers.eachOddCharIsOne("0010111")).isFalse();
    }
}

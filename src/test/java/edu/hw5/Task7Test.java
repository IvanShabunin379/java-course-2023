package edu.hw5;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class Task7Test {
    @Test
    public void testContainsAtLeastThreeCharsAndThirdCharIsZero() {
        assertThat(Task7.containsAtLeastThreeCharsAndThirdCharIsZero("000")).isTrue();
        assertThat(Task7.containsAtLeastThreeCharsAndThirdCharIsZero("11011")).isTrue();
        assertThat(Task7.containsAtLeastThreeCharsAndThirdCharIsZero("010101")).isTrue();

        assertThat(Task7.containsAtLeastThreeCharsAndThirdCharIsZero("")).isFalse();
        assertThat(Task7.containsAtLeastThreeCharsAndThirdCharIsZero("00")).isFalse();
        assertThat(Task7.containsAtLeastThreeCharsAndThirdCharIsZero("1")).isFalse();
    }

    @Test
    public void testStartsAndEndsWithSameChar() {
        assertThat(Task7.startsAndEndsWithSameChar("1")).isTrue();
        assertThat(Task7.startsAndEndsWithSameChar("101")).isTrue();
        assertThat(Task7.startsAndEndsWithSameChar("00000")).isTrue();
        assertThat(Task7.startsAndEndsWithSameChar("01000110100")).isTrue();

        assertThat(Task7.startsAndEndsWithSameChar("01")).isFalse();
        assertThat(Task7.startsAndEndsWithSameChar("1000")).isFalse();
        assertThat(Task7.startsAndEndsWithSameChar("000111001")).isFalse();
    }

    @Test
    public void testIsNoShorterThanOneAndNotLongerThanThree() {
        assertThat(Task7.isNoShorterThanOneAndNotLongerThanThree("0")).isTrue();
        assertThat(Task7.isNoShorterThanOneAndNotLongerThanThree("01")).isTrue();
        assertThat(Task7.isNoShorterThanOneAndNotLongerThanThree("111")).isTrue();

        assertThat(Task7.isNoShorterThanOneAndNotLongerThanThree("")).isFalse();
        assertThat(Task7.isNoShorterThanOneAndNotLongerThanThree("1001")).isFalse();
        assertThat(Task7.isNoShorterThanOneAndNotLongerThanThree("00010100110")).isFalse();
    }
}

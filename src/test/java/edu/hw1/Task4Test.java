package edu.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class Task4Test {
    @Test
    public void stringWithEvenLengthShouldReturnThisStringWithSwappedEveryPairOfChars() {
        String input = "оПомигети псаривьтс ртко!и";
        String expected = "Помогите исправить строки!";
        assertThat(Task4.fixString(input)).isEqualTo(expected);

        input = "123456";
        expected = "214365";
        assertThat(Task4.fixString(input)).isEqualTo(expected);

        input = "hTsii  s aimex dpus rtni.g";
        expected = "This is a mixed up string.";
        assertThat(Task4.fixString(input)).isEqualTo(expected);
    }

    @Test
    public void stringWithOddLengthShouldReturnThisStringSwappedPairEveryPairOfChars() {
        String input = "badce";
        String expected = "abcde";
        assertThat(Task4.fixString(input)).isEqualTo(expected);
    }

    @Test
    public void emptyStringShouldReturnItself() {
        String input = "";
        String expected = "";
        assertThat(Task4.fixString(input)).isEqualTo(expected);
    }

    @Test
    public void stringWithSingleCharShouldReturnItself() {
        String input = "a";
        String expected = "a";
        assertThat(Task4.fixString(input)).isEqualTo(expected);
    }

    @Test
    public void stringWithTwoCharsShouldReturnReverseThisString() {
        String input = "ab";
        String expected = "ba";
        assertThat(Task4.fixString(input)).isEqualTo(expected);
    }

    @Test
    public void stringWithSpecialCharsShouldReturnThisStringStringWithSwappedEveryPairOfChars() {
        String input = "!@#$%^";
        String expected = "@!$#^%";
        assertThat(Task4.fixString(input)).isEqualTo(expected);
    }
}

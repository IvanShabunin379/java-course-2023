package edu.hw3.task4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArabicToRomanConverterTest {
    @Test
    public void shouldReturnNumberInRomanNotation() {
        assertThat(ArabicToRomanConverter.convertToRoman(2)).isEqualTo("II");
        assertThat(ArabicToRomanConverter.convertToRoman(12)).isEqualTo("XII");
        assertThat(ArabicToRomanConverter.convertToRoman(16)).isEqualTo("XVI");
        assertThat(ArabicToRomanConverter.convertToRoman(30)).isEqualTo("XXX");
        assertThat(ArabicToRomanConverter.convertToRoman(700)).isEqualTo("DCC");
        assertThat(ArabicToRomanConverter.convertToRoman(3000)).isEqualTo("MMM");
        assertThat(ArabicToRomanConverter.convertToRoman(3999)).isEqualTo("MMMCMXCIX");

    }

    @Test
    public void whenNumberIsNotFromValidDiapasonShouldReturnNull() {
        assertThat(ArabicToRomanConverter.convertToRoman(-12)).isNull();
        assertThat(ArabicToRomanConverter.convertToRoman(0)).isNull();
        assertThat(ArabicToRomanConverter.convertToRoman(0)).isNull();
        assertThat(ArabicToRomanConverter.convertToRoman(4000)).isNull();
        assertThat(ArabicToRomanConverter.convertToRoman(5555)).isNull();
    }
}

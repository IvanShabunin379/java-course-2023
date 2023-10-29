package edu.hw3.task1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AtbashCipherTest {
    @Test
    public void whenEnglishLettersShouldReturnMirroredLetters() {
        String input = "Hello world!";
        String expected = "Svool dliow!";
        assertThat(AtbashCipher.atbash(input)).isEqualTo(expected);

        input =
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";
        expected =
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";
        assertThat(AtbashCipher.atbash(input)).isEqualTo(expected);
    }

    @Test
    public void whenNotLettersShouldReturnThemselves() {
        String input = "12340!@#$";
        assertThat(AtbashCipher.atbash(input)).isEqualTo(input);
    }

    @Test
    public void whenLettersAreNotEnglishShouldReturnThemselves() {
        String input = "Привет, мир!";
        assertThat(AtbashCipher.atbash(input)).isEqualTo(input);
    }

    @Test
    public void whenEmptyStringShouldReturnItself() {
        String input = "";
        assertThat(AtbashCipher.atbash(input)).isEqualTo(input);
    }
}

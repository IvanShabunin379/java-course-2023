package edu.hw5.task4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {
    @Test
    public void whenStringContainsSpecialCharFromConditionShouldReturnTrue() {
        assertThat(PasswordValidator.containsSpecialCharacter("~qwerty")).isTrue();
        assertThat(PasswordValidator.containsSpecialCharacter("qwe!$rty")).isTrue();
        assertThat(PasswordValidator.containsSpecialCharacter("qwerty#%")).isTrue();
    }

    @Test
    public void whenStringContainsOnlySpecialCharsFromConditionShouldReturnTrue() {
        assertThat(PasswordValidator.containsSpecialCharacter("~!#$%^&*|")).isTrue();
        assertThat(PasswordValidator.containsSpecialCharacter("a|bc!#~$%d*&fg^")).isTrue();
        assertThat(PasswordValidator.containsSpecialCharacter("#")).isTrue();
    }

    @Test
    public void whenStringContainsCharFromConditionThatMeansSmthInRegexesShouldReturnTrue() {
        assertThat(PasswordValidator.containsSpecialCharacter("^*|$")).isTrue();
        assertThat(PasswordValidator.containsSpecialCharacter("qwe^ty*")).isTrue();
    }

    @Test
    public void whenStringDoesNotContainSpecialCharFromConditionShouldReturnFalse() {
        assertThat(PasswordValidator.containsSpecialCharacter("12345")).isFalse();
        assertThat(PasswordValidator.containsSpecialCharacter("qwerty")).isFalse();
        assertThat(PasswordValidator.containsSpecialCharacter("+-/")).isFalse();
    }

    @Test
    public void whenStringIsEmptyShouldReturnFalse() {
        assertThat(PasswordValidator.containsSpecialCharacter("")).isFalse();
    }

}

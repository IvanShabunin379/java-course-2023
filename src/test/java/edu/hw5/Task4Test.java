package edu.hw5;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class Task4Test {
    @Test
    public void whenStringContainsSpecialCharFromConditionShouldReturnTrue() {
        assertThat(Task4.containsSpecialCharacter("~qwerty")).isTrue();
        assertThat(Task4.containsSpecialCharacter("qwe!$rty")).isTrue();
        assertThat(Task4.containsSpecialCharacter("qwerty#%")).isTrue();
    }

    @Test
    public void whenStringContainsOnlySpecialCharsFromConditionShouldReturnTrue() {
        assertThat(Task4.containsSpecialCharacter("~!#$%^&*|")).isTrue();
        assertThat(Task4.containsSpecialCharacter("a|bc!#~$%d*&fg^")).isTrue();
        assertThat(Task4.containsSpecialCharacter("#")).isTrue();
    }

    @Test
    public void whenStringContainsCharFromConditionThatMeansSmthInRegexesShouldReturnTrue() {
        assertThat(Task4.containsSpecialCharacter("^*|$")).isTrue();
        assertThat(Task4.containsSpecialCharacter("qwe^ty*")).isTrue();
    }

    @Test
    public void whenStringDoesNotContainSpecialCharFromConditionShouldReturnFalse() {
        assertThat(Task4.containsSpecialCharacter("12345")).isFalse();
        assertThat(Task4.containsSpecialCharacter("qwerty")).isFalse();
        assertThat(Task4.containsSpecialCharacter("+-/")).isFalse();
    }

    @Test
    public void whenStringIsEmptyShouldReturnFalse() {
        assertThat(Task4.containsSpecialCharacter("")).isFalse();
    }

}

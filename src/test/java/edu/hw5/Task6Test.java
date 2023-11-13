package edu.hw5;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class Task6Test {
    @Test
    public void testIsSubsequence() {
        assertThat(Task6.isSubsequence("abc", "achfdbaabgabcaabg")).isTrue();
        assertThat(Task6.isSubsequence("achfdbaabgabcaabg", "abc")).isFalse();
    }
}

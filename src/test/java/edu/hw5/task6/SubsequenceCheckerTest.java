package edu.hw5.task6;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class SubsequenceCheckerTest {
    @Test
    public void testIsSubsequence() {
        assertThat(SubsequenceChecker.isSubsequence("abc", "achfdbaabgabcaabg")).isTrue();
        assertThat(SubsequenceChecker.isSubsequence("achfdbaabgabcaabg", "abc")).isFalse();
    }
}

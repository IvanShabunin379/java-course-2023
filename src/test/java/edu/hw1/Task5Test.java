package edu.hw1;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class Task5Test {
    @Test
    public void palindromeNumberShouldReturnTrue() {
        assertTrue(Task5.isPalindromeDescendant(11));
        assertTrue(Task5.isPalindromeDescendant(121));
        assertTrue(Task5.isPalindromeDescendant(321123));
    }

    @Test
    public void notPalindromeWithPalindromeDescendantsShouldReturnTrue() {
        assertTrue(Task5.isPalindromeDescendant(123312));
        assertTrue(Task5.isPalindromeDescendant(11211230));
        assertTrue(Task5.isPalindromeDescendant(13001120));
        assertTrue(Task5.isPalindromeDescendant(23336014));
    }

    @Test
    public void notPalindromeWithoutPalindromeDescendantsShouldReturnFalse() {
        assertFalse(Task5.isPalindromeDescendant(123));
        assertFalse(Task5.isPalindromeDescendant(9870));
    }

    @Test
    public void negativeNumberShouldReturnFalse() {
        assertFalse(Task5.isPalindromeDescendant(-121));
        assertFalse(Task5.isPalindromeDescendant(-123));
        assertFalse(Task5.isPalindromeDescendant(-5));
    }

    @Test
    public void NumberWithOneDigitShouldReturnTrue() {
        assertTrue(Task5.isPalindromeDescendant(1));
        assertTrue(Task5.isPalindromeDescendant(9));
        assertTrue(Task5.isPalindromeDescendant(0));
    }
}

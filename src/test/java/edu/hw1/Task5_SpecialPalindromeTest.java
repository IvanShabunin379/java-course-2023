package edu.hw1;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class Task5_SpecialPalindromeTest {
    @Test
    public void palindromeNumberShouldReturnTrue() {
        assertTrue(Task5_SpecialPalindrome.isPalindromeDescendant(11));
        assertTrue(Task5_SpecialPalindrome.isPalindromeDescendant(121));
        assertTrue(Task5_SpecialPalindrome.isPalindromeDescendant(321123));
    }

    @Test
    public void notPalindromeWithPalindromeDescendantsShouldReturnTrue() {
        assertTrue(Task5_SpecialPalindrome.isPalindromeDescendant(123312));
        assertTrue(Task5_SpecialPalindrome.isPalindromeDescendant(11211230));
        assertTrue(Task5_SpecialPalindrome.isPalindromeDescendant(13001120));
        assertTrue(Task5_SpecialPalindrome.isPalindromeDescendant(23336014));
    }

    @Test
    public void notPalindromeWithoutPalindromeDescendantsShouldReturnFalse() {
        assertFalse(Task5_SpecialPalindrome.isPalindromeDescendant(123));
        assertFalse(Task5_SpecialPalindrome.isPalindromeDescendant(9870));
    }

    @Test
    public void negativeNumberShouldReturnFalse() {
        assertFalse(Task5_SpecialPalindrome.isPalindromeDescendant(-121));
        assertFalse(Task5_SpecialPalindrome.isPalindromeDescendant(-123));
        assertFalse(Task5_SpecialPalindrome.isPalindromeDescendant(-5));
    }

    @Test
    public void NumberWithOneDigitShouldReturnTrue() {
        assertTrue(Task5_SpecialPalindrome.isPalindromeDescendant(1));
        assertTrue(Task5_SpecialPalindrome.isPalindromeDescendant(9));
        assertTrue(Task5_SpecialPalindrome.isPalindromeDescendant(0));
    }
}

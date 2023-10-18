package edu.hw1;

import java.util.Arrays;

public final class Task6 {
    private static final int KAPREKAR_CONST = 6174;

    private Task6() {
    }

    public static int getKaprekarConst() {
        return KAPREKAR_CONST;
    }

    public static int countK(int number) {
        final int MIN_FOUR_DIGIT_NUMBER = 1000;
        final int MAX_FOUR_DIGIT_NUMBER = 9999;
        if ((number <= MIN_FOUR_DIGIT_NUMBER) || (number >= MAX_FOUR_DIGIT_NUMBER) || allDigitsAreEqual(number)) {
            return -1;
        }

        return countKRecursive(number, 0);
    }

    private static int countKRecursive(int number, int steps) {
        int currentNumber = number;

        if (currentNumber == KAPREKAR_CONST) {
            return steps;
        } else {
            currentNumber = kaprekar(currentNumber);
            return countKRecursive(currentNumber, steps + 1);
        }
    }

    private static int kaprekar(int number) {
        if (number == KAPREKAR_CONST) {
            return number;
        }

        final int COUNT_DIGITS_IN_NUMBER = 4;
        final int RADIX = 10;
        final int RADIX_SQR = 100;
        final int RADIX_CUBE = 1000;

        int[] digits = new int[COUNT_DIGITS_IN_NUMBER];

        int copyOfNumber = number;
        for (int i = COUNT_DIGITS_IN_NUMBER - 1; i >= 0; i--) {
            digits[i] = copyOfNumber % RADIX;
            copyOfNumber /= RADIX;
        }

        Arrays.sort(digits);

        int ascending =
            digits[0] * RADIX_CUBE + digits[1] * RADIX_SQR + digits[2] * RADIX + digits[COUNT_DIGITS_IN_NUMBER - 1];
        int descending =
            digits[COUNT_DIGITS_IN_NUMBER - 1] * RADIX_CUBE + digits[2] * RADIX_SQR + digits[1] * RADIX + digits[0];

        return descending - ascending;
    }

    private static boolean allDigitsAreEqual(int number) {
        int copyOfNumber = number;
        final int RADIX = 10;

        int currentDigit = copyOfNumber % RADIX;
        while (copyOfNumber >= RADIX) {
            copyOfNumber /= RADIX;
            int previousDigit = currentDigit;
            currentDigit = copyOfNumber % RADIX;
            if (currentDigit != previousDigit) {
                return false;
            }
        }

        return true;
    }
}

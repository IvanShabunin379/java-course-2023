package edu.hw1;

import java.util.Arrays;

public class Task6_KaprekarConstant {
    private static final int KAPREKAR_CONST = 6174;

    public static int getKaprekarConst() {
        return KAPREKAR_CONST;
    }

    public static int countK(int number) {
        if (number <= 1000 || number >= 9999 || allDigitsAreEqual(number)) {
            return -1;
        }

        return countKRecursive(number, 0);
    }

    private static int countKRecursive(int number, int steps) {
        if (number == KAPREKAR_CONST) {
            return steps;
        } else {
            number = kaprekar(number);
            return countKRecursive(number, steps + 1);
        }
    }

    private static int kaprekar(int number) {
        if (number == KAPREKAR_CONST) {
            return number;
        }

        int[] digits = new int[4];

        for (int i = 3; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        Arrays.sort(digits);

        int ascending = digits[0] * 1000 + digits[1] * 100 + digits[2] * 10 + digits[3];
        int descending = digits[3] * 1000 + digits[2] * 100 + digits[1] * 10 + digits[0];

        return descending - ascending;
    }

    private static boolean allDigitsAreEqual(int number) {
        return number == 1111 || number == 2222 || number == 3333 || number == 4444 || number == 5555 || number == 6666
            || number == 7777 || number == 8888 || number == 9999;
    }
}

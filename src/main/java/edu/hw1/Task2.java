package edu.hw1;

public final class Task2 {
    private Task2() {
    }

    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }

        int count = 0;

        int copyOfNumber = number;
        final int RADIX = 10;
        while (copyOfNumber != 0) {
            ++count;
            copyOfNumber /= RADIX;
        }

        return count;
    }
}

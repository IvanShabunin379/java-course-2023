package edu.hw1;

public class Task2_CountDigits {
    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }

        int count = 0;

        while (number != 0) {
            ++count;
            number /= 10;
        }

        return count;
    }
}

package edu.hw7.task2;

import java.util.stream.LongStream;

public final class FactorialCalculator {
    private FactorialCalculator() {
    }

    public static long calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(
                "Input number must be non-negative. Factorials of negative numbers do not exist.");
        }

        if (number == 0 || number == 1) {
            return 1;
        }

        return LongStream.rangeClosed(1, number)
            .parallel()
            .reduce((acc, cur) -> acc * cur)
            .getAsLong();
    }
}

package edu.hw7.task2;

import java.util.stream.IntStream;

public class FactorialCalculator {
    public static int calculateFactorial(int number) {
        return IntStream.rangeClosed(1, number)
            .parallel()
            .reduce((acc, cur) -> acc * cur)
            .getAsInt();
    }
}

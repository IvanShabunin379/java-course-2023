package edu.hw7.task4;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAdder;

public final class MonteCarlo {
    private static final int RATIO_OF_SQUARE_AND_CIRCLE_AREAS_DIVIDED_BY_PI = 4;

    private MonteCarlo() {
    }

    public static double calculatePi(long numberOfIterations) {
        int totalCount = 0;
        int circleCount = 0;

        Random random = new Random();

        for (int i = 0; i < numberOfIterations; ++i) {
            double x = random.nextDouble(1.0);
            double y = random.nextDouble(1.0);

            if (x * x + y * y <= 1) {
                ++circleCount;
            }

            ++totalCount;
        }

        return RATIO_OF_SQUARE_AND_CIRCLE_AREAS_DIVIDED_BY_PI * ((double) circleCount / totalCount);
    }

    public static double calculateMultithreaded(long numberOfIterations, int numberOfThreads) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads)) {
            LongAdder totalCircleCount = new LongAdder();
            long nIterationsPerThread = Math.ceilDiv(numberOfIterations, numberOfThreads);

            for (int i = 0; i < numberOfThreads; ++i) {
                executorService.submit(() -> {
                    long threadCircleCount = calculateCircleCount(nIterationsPerThread);
                    totalCircleCount.add(threadCircleCount);
                });
            }

            executorService.shutdown();

            return (double) (RATIO_OF_SQUARE_AND_CIRCLE_AREAS_DIVIDED_BY_PI
                * totalCircleCount.sum()) / numberOfIterations;
        }
    }

    private static long calculateCircleCount(long nIterationsPerThread) {
        long circleCount = 0;

        for (int i = 0; i < nIterationsPerThread; ++i) {
            double x = ThreadLocalRandom.current().nextDouble();
            double y = ThreadLocalRandom.current().nextDouble();

            if (x * x + y * y <= 1) {
                ++circleCount;
            }
        }

        return circleCount;
    }
}

package edu.hw7.task4;

import java.util.List;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class MonteCarloEfficiencyAnalyzer {
    private final static int NUMBER_OF_THREADS = 12;
    private final static int NUMBER_OF_ITERATIONS = 1000000;
    private final static int NUMBER_OF_SIMULATIONS = 100;
    private final static int NANOS_IN_MILLIS = 1000000;
    private static final Logger LOGGER = LogManager.getLogger();

    private MonteCarloEfficiencyAnalyzer() {
    }

    @SuppressWarnings({"UncommentedMain", "MagicNumber"})
    public static void main(String[] args) {
        printAverageExecutionTime(IntStream.rangeClosed(1, NUMBER_OF_THREADS).boxed().toList());
        printComputationalErrors(List.of(10000000L, 100000000L, 1000000000L));
    }

    public static void printAverageExecutionTime(List<Integer> numberOfThreads) {
        for (var number : numberOfThreads) {
            LOGGER.info("Number of threads: " + number + "\tAverage execution time: " + measureAverageTime(number));
        }
    }

    public static void printComputationalErrors(List<Long> numberOfIterations) {
        for (var number : numberOfIterations) {
            LOGGER.info("Number of iterations: " + number + "\tComputational error: "
                + calculateComputationError(number));
        }
    }

    private static double measureAverageTime(int numberOfThreads) {
        long startTime = System.nanoTime();

        for (int i = 0; i < NUMBER_OF_SIMULATIONS; ++i) {
            MonteCarlo.calculateMultithreaded(NUMBER_OF_ITERATIONS, numberOfThreads);
        }

        return (double) (System.nanoTime() - startTime) / NUMBER_OF_SIMULATIONS / NANOS_IN_MILLIS;
    }

    private static double calculateComputationError(long numberOfIterations) {
        return Math.abs(MonteCarlo.calculateMultithreaded(numberOfIterations, NUMBER_OF_THREADS) - Math.PI);
    }
}

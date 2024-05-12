package edu.hw7.task4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.within;
import org.junit.jupiter.api.RepeatedTest;

public class MonteCarloTest {
    private static final int NUMBER_OF_REPETITIONS = 100;
    private static final double EPS = 0.01;
    private static final long NUMBER_OF_ITERATIONS = 1000000;
    private static final int NUMBER_OF_THREADS = 12;

    @RepeatedTest(NUMBER_OF_REPETITIONS)
    public void PIShouldCountCorrectly() {
        double pi = MonteCarlo.calculatePi(NUMBER_OF_ITERATIONS);
        assertThat(pi).isCloseTo(Math.PI, within(EPS));
    }

    @RepeatedTest(NUMBER_OF_REPETITIONS)
    public void PIShouldCountCorrectlyWithConcurrency() {
        assertThat(MonteCarlo.calculateMultithreaded(NUMBER_OF_ITERATIONS, NUMBER_OF_THREADS))
            .isCloseTo(Math.PI, within(EPS));
    }
}

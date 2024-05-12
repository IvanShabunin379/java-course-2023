package edu.hw7.task1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AtomicCounterUtilTest {
    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "1, 10000",
        "2, 10000",
        "5, 10000",
        "10, 100000",
        "12, 100000",
        "120, 100000"
    })
    public void testIncreaseCounterByMultipleThreads(int numberOfThreads, int numberOfIncrementsPerThread)
        throws InterruptedException {
        AtomicCounter counter = new AtomicCounter();
        AtomicCounterUtil.increaseCounterByMultipleThreads(counter, numberOfThreads, numberOfIncrementsPerThread);
        assertThat(counter.getValue()).isEqualTo(numberOfThreads * numberOfIncrementsPerThread);
    }
}

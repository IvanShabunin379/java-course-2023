package edu.hw7.task1;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class AtomicCounterTest {
    @Test
    public void shouldBeThreadSafe() throws InterruptedException {
        AtomicCounter counter = new AtomicCounter();
        AtomicCounterUtil.increaseCounterByMultipleThreads(counter, 6, 10000);
        assertThat(counter.getValue()).isEqualTo(60000);
    }
}

package edu.hw7.task1;

import java.util.ArrayList;
import java.util.List;

public final class AtomicCounterUtil {
    private AtomicCounterUtil() {
    }

    public static void increaseCounterByMultipleThreads(
        AtomicCounter counter,
        int numberOfThreads,
        int numberOfIncrementsPerThread
    )
        throws InterruptedException {
        List<Thread> threads = new ArrayList<>(numberOfThreads);

        for (int i = 0; i < numberOfThreads; ++i) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < numberOfIncrementsPerThread; ++j) {
                    counter.increment();
                }
            }));
        }

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }
    }
}

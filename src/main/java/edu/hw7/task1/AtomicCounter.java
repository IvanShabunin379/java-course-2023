package edu.hw7.task1;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private final AtomicInteger counter = new AtomicInteger(0);

    public int getValue() {
        return counter.get();
    }

    public void increment() {
        counter.getAndIncrement();
    }
}

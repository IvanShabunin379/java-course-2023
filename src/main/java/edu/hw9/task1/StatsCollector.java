package edu.hw9.task1;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StatsCollector {
    private final ConcurrentMap<String, Statistics> metrics;

    private final ExecutorService executorService;

    public StatsCollector() {
        metrics = new ConcurrentHashMap<>();
        executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors());
    }

    public void push(String metricName, double[] data) {
        executorService.execute(() -> {
            synchronized (metrics) {
                if (!metricName.isEmpty()) {
                    metrics.compute(metricName, (key, oldValue) -> {
                        if (oldValue == null) {
                            return new Statistics(data);
                        } else {
                            //synchronized (metrics) {
                            return oldValue.updateStatistics(data);
                            //}
                        }

                    });
                }
            }
        });
    }

    public Map<String, Statistics> stats() {
        return Collections.unmodifiableMap(metrics);
    }

    @SuppressWarnings("MagicNumber")
    public void closeCollector() throws InterruptedException {
        executorService.awaitTermination(10, TimeUnit.MILLISECONDS);
        executorService.shutdown();
    }
}

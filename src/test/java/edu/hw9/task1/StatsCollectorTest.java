package edu.hw9.task1;

import java.util.HashMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class StatsCollectorTest {
    private static final int TEST_REPETITIONS = 100;

    private StatsCollector collector;

    @BeforeEach
    public void setCollector() {
        collector = new StatsCollector();
    }

    @RepeatedTest(100)
    public void collectorShouldCorrectlyCollectInfo() throws InterruptedException {
        for (int i = 0; i < TEST_REPETITIONS; i++) {
            collector.push(
                "metric_name" + i,
                new double[] {0.1, 0.05, 1.4, 5.1, 0.3}
            );
        }
        collector.closeCollector();
        Assertions.assertThat(collector.stats().size()).isEqualTo(TEST_REPETITIONS);
    }

    @RepeatedTest(100)
    public void collectorShouldCorrectlyGetStats() throws InterruptedException {

        collector.push(
            "metric_name",
            new double[] {0.4, 0.9, 1.2}
        );
        collector.push(
            "metric_name",
            new double[] {0.1, 0.05}
        );
        collector.push(
            "metric_name",
            new double[] {3.35}
        );
        collector.push(
            "metric_name2",
            new double[] {0.1, 0.05, 1.4, 5.1, 0.3}
        );
        collector.push(
            "metric_name2",
            new double[] {0.4, 0.65, 0}
        );
        collector.push(
            "metric_name3",
            new double[] {2}
        );
        collector.closeCollector();
        Assertions.assertThat(collector.stats()).containsExactlyInAnyOrderEntriesOf(new HashMap<>() {
            {
                put("metric_name", new Statistics(6, 1, 3.35, 0.05, 6));
                put("metric_name2", new Statistics(8, 1,5.1,0, 8));
                put("metric_name3", new Statistics(2,2,2,2,1));
            }});
        Assertions.assertThat(collector.stats().size()).isEqualTo(3);
    }
}

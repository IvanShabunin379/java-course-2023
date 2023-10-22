package edu.hw1;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public final class Task3 {
    private Task3() {
    }

    public static boolean isNestable(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return false;
        }

        IntSummaryStatistics stats1 = Arrays.stream(arr1).summaryStatistics();
        IntSummaryStatistics stats2 = Arrays.stream(arr2).summaryStatistics();

        return (stats1.getMin() > stats2.getMin()) && (stats1.getMax() < stats2.getMax());
    }
}

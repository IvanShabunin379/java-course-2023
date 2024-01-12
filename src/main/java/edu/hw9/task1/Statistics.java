package edu.hw9.task1;

import java.util.Objects;

public class Statistics {
    private static final double EPSILON = 1e-10;
    private double sum;
    private double average;
    private double max;
    private double min;
    private int count;

    public Statistics(double sum, double average, double max, double min, int count) {
        this.sum = sum;
        this.average = average;
        this.max = max;
        this.min = min;
        this.count = count;
    }

    public Statistics(double[] data) {
        max = data[0];
        min = data[0];

        for (int i = 0; i < data.length; i++) {
            sum += data[i];
            count++;

            if (min > data[i]) {
                min = data[i];
            } else if (max < data[i]) {
                max = data[i];
            }
        }

        average = sum / count;
    }

    public double getSum() {
        return sum;
    }

    public double getAverage() {
        return average;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public int getCount() {
        return count;
    }

    public Statistics updateStatistics(double[] data) {
        double currSum = sum;
        double currMax = max;
        double currMin = min;
        int currCount = count;

        for (int i = 0; i < data.length; i++) {
            currSum += data[i];
            currCount++;

            if (currMin > data[i]) {
                currMin = data[i];
            } else if (currMax < data[i]) {
                currMax = data[i];
            }
        }

        double currAverage = currSum / currCount;

        return new Statistics(currSum, currAverage, currMax, currMin, currCount);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Statistics that = (Statistics) o;

        return Math.abs(that.sum - sum) < EPSILON
            && Math.abs(that.average - average) < EPSILON
            && Math.abs(that.max - max) < EPSILON
            && Math.abs(that.min - min) < EPSILON
            && count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum, average, max, min, count);
    }
}


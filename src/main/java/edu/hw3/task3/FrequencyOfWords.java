package edu.hw3.task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FrequencyOfWords {
    private FrequencyOfWords() {
    }

    public static <T> Map<T, Integer> freqDict(List<T> items) {
        Map<T, Integer> result = new HashMap<>();

        for (T item : items) {
            if (!result.containsKey(item)) {
                result.put(item, 1);
            } else {
                result.put(item, result.get(item) + 1);
            }
        }

        return result;
    }
}

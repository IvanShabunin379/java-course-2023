package edu.hw3.task3;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrequencyOfWordsTest {
    @Test
    public void whenListOfStringsShouldReturnMapWithEveryStringFrequency() {
        List<String> inputList = List.of("this", "and", "that", "and");
        Map<String, Integer> result = FrequencyOfWords.freqDict(inputList);

        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get("this")).isEqualTo(1);
        assertThat(result.get("that")).isEqualTo(1);
        assertThat(result.get("and")).isEqualTo(2);

        inputList = List.of("код", "код", "код", "bug");
        result = FrequencyOfWords.freqDict(inputList);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get("код")).isEqualTo(3);
        assertThat(result.get("bug")).isEqualTo(1);
    }

    @Test
    public void whenListOfIntegersShouldReturnMapWithEveryIntegerFrequency() {
        List<Integer> inputList = List.of(1, 1, 2, 2);
        Map<Integer, Integer> result = FrequencyOfWords.freqDict(inputList);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(1)).isEqualTo(2);
        assertThat(result.get(2)).isEqualTo(2);
    }

    @Test
    public void whenListOfCharsShouldReturnMapWithEveryCharFrequency() {
        List<Character> inputList = List.of('a', 'b', 'a', 'b');
        Map<Character, Integer> result = FrequencyOfWords.freqDict(inputList);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get('a')).isEqualTo(2);
        assertThat(result.get('b')).isEqualTo(2);
    }

    @Test
    public void whenListOfBooleanValuesShouldReturnMapWithEveryBooleanValueFrequency() {
        List<Boolean> inputList = List.of(true, false, true, true, false, true);
        Map<Boolean, Integer> result = FrequencyOfWords.freqDict(inputList);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(true)).isEqualTo(4);
        assertThat(result.get(false)).isEqualTo(2);
    }

    @Test
    public void whenListOfDoubleShouldReturnMapWithEveryDoubleFrequency() {
        List<Double> inputList = List.of(3.14, 2.7, 9.58, 2.7, 3.14);
        Map<Double, Integer> result = FrequencyOfWords.freqDict(inputList);

        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(3.14)).isEqualTo(2);
        assertThat(result.get(2.7)).isEqualTo(2);
        assertThat(result.get(9.58)).isEqualTo(1);
    }

    @Test
    public void whenEmptyListShouldReturnEmptyMap() {
        var inputList = List.of();
        var result = FrequencyOfWords.freqDict(inputList);
        assertTrue(result.isEmpty());
    }
}

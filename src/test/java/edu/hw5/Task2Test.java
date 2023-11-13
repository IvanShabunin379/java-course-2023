package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task2Test {
    @Test
    public void testFindALlFridaysThe13InYear() {
        List<LocalDate> result = Task2.findALlFridaysThe13InYear(1925);
        List<LocalDate> expected = List.of(
            LocalDate.of(1925, 2, 13),
            LocalDate.of(1925, 3, 13),
            LocalDate.of(1925, 11, 13)
        );
        assertThat(result).isEqualTo(expected);

        result = Task2.findALlFridaysThe13InYear(2024);
        expected = List.of(
            LocalDate.of(2024, 9, 13),
            LocalDate.of(2024, 12, 13)
        );
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testFindNextFridayThe13() {
        LocalDate result = Task2.findNextFridayThe13(LocalDate.of(1925, 2, 13));
        LocalDate expected = LocalDate.of(1925, 3, 13);
        assertThat(result).isEqualTo(expected);

        result = Task2.findNextFridayThe13(LocalDate.of(2023, 11, 13));
        expected = LocalDate.of(2024, 9, 13);
        assertThat(result).isEqualTo(expected);
    }
}

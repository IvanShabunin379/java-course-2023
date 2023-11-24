package edu.hw5.task2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.util.List;

public class FridayThe13FinderTest {
    @Test
    public void testFindALlFridaysThe13InYear() {
        List<LocalDate> result = FridayThe13Finder.findALlFridaysThe13InYear(1925);
        List<LocalDate> expected = List.of(
            LocalDate.of(1925, 2, 13),
            LocalDate.of(1925, 3, 13),
            LocalDate.of(1925, 11, 13)
        );
        assertThat(result).isEqualTo(expected);

        result = FridayThe13Finder.findALlFridaysThe13InYear(2024);
        expected = List.of(
            LocalDate.of(2024, 9, 13),
            LocalDate.of(2024, 12, 13)
        );
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testFindNextFridayThe13() {
        LocalDate result = FridayThe13Finder.findNextFridayThe13(LocalDate.of(1925, 2, 13));
        LocalDate expected = LocalDate.of(1925, 3, 13);
        assertThat(result).isEqualTo(expected);

        result = FridayThe13Finder.findNextFridayThe13(LocalDate.of(2023, 11, 13));
        expected = LocalDate.of(2024, 9, 13);
        assertThat(result).isEqualTo(expected);
    }
}

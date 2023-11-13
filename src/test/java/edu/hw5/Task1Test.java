package edu.hw5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Task1Test {
    @Test
    public void whenValidInputShouldReturnRightAverageSessionDuration() {
        List<String> input = List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        );
        Duration result = Task1.calculateAverageSessionDuration(input);
        Duration expected = Duration.ofMinutes(220);
        assertThat(result).isEqualTo(expected);

        input = List.of(
            "2023-01-01, 10:00 - 2023-01-01, 11:00",
            "2023-01-01, 13:00 - 2023-01-01, 14:30",
            "2023-01-01, 15:00 - 2023-01-01, 15:45"
        );
        result = Task1.calculateAverageSessionDuration(input);
        expected = Duration.ofMinutes(65);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenEmptyInputListShouldReturnZeroDuration() {
        List<String> input = new ArrayList<>();
        assertThat(Task1.calculateAverageSessionDuration(input)).isEqualTo(Duration.ZERO);
    }

    @Test
    public void whenInvalidInputStringsShouldThrowException() {
        List<String> input = List.of(
            "2023-01-01, 10:00 - 2023-01-01, 11:00",
            "2023-01-01, 10:00 - 2023-01-01, 11:00 - 2023-01-01, 14:00",
            "2023-01-01, 13:00 - 2023-01-01, 14:30"
        );

        assertThatIllegalArgumentException().isThrownBy(() -> Task1.calculateAverageSessionDuration(input));
    }

    @Test
    public void whenInputStringsContainInvalidDateShouldThrowException() {
        List<String> input = List.of(
            "2023-01-01, 10:00 - 2023-01-01, 11:00",
            "2023-01-01, 13:00 - 2023-01-01, 14:30",
            "2023-01-01, 15:00 - 2023-01-01, 15:45",
            "2023-01-01, 16:00 - 01.01.2023 19-00"
        );

        assertThatIllegalArgumentException().isThrownBy(() -> Task1.calculateAverageSessionDuration(input));
    }

    @Test
    public void whenInputStringsContainEndDateIsBeforeStartDateShouldThrowException() {
        List<String> input = List.of(
            "2023-01-01, 10:00 - 2023-01-01, 11:00",
            "2023-01-01, 13:00 - 2023-01-01, 14:30",
            "2023-01-01, 15:00 - 2023-01-01, 15:45",
            "2023-01-01, 16:00 - 2023-01-01, 15:30"
        );

        assertThatIllegalArgumentException().isThrownBy(() -> Task1.calculateAverageSessionDuration(input));
    }
}
